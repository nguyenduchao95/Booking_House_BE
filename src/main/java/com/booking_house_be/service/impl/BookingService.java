package com.booking_house_be.service.impl;

import com.booking_house_be.dto.BillPDF;
import com.booking_house_be.dto.query.SpendingDto;
import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.entity.Review;
import com.booking_house_be.repository.IAccountRepo;
import com.booking_house_be.repository.IBookingRepo;
import com.booking_house_be.repository.IReviewRepo;
import com.booking_house_be.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepo bookingRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private IAccountRepo accountRepo;
    @Autowired
    private IReviewRepo reviewRepo;

    @Override
    public List<Booking> findAllByHouseIdAndStatus(int houseId) {
        return bookingRepo.findAllByHouseIdAndStatus(houseId);
    }

    @Override
    public Booking bookingHouse(Booking booking) {
        Account account = accountRepo.findById(booking.getAccount().getId()).get();
        booking.setAccount(account);
        try {
            String subject = "Thông báo lịch thuê mới";
            String toEmail = booking.getHouse().getOwner().getEmail();
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
            String content = "<b>Chào bạn</b>,<br><p>Nhà của bạn đang có khách hàng đặt lịch. Thông tin lịch đặt:</p>"
                    + "<p>- Ngôi nhà thuê: " + booking.getHouse().getName() + "</p>"
                    + "<p>- Địa chỉ: " + booking.getHouse().getAddress() + "</p>"
                    + "<p>- Khách hàng: " + booking.getAccount().getUsername() + "</p>"
                    + "<p>- Email: " + booking.getAccount().getEmail() + "</p>"
                    + "<p>- Thời gian thuê: Từ" + BillPDF.formatTime(booking.getStartTime()) + " đến " + BillPDF.formatTime(booking.getEndTime()) + "</p>"
                    + "<p>- Tổng tiền: " + numberFormat.format(booking.getTotal()) + "</p>"
                    + "<br><p>Vui lòng đăng nhập vào website: <a href='http://localhost:3000' target='_blank'>https://www.LUXURY.com</a> để xác nhận lịch thuê.</p>";
            emailService.sendEmailBooking(subject, toEmail, content);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return bookingRepo.save(booking);
    }

    @Override
    public Booking waitOwnerConfirmBooking(int bookingId) {
        Booking booking = bookingRepo.findById(bookingId);
        if (booking.getStatus().equals("Chờ xác nhận")) {
            booking.setStatus("Chờ nhận phòng");
            try {
                emailService.sendBill(booking.getAccount().getEmail(), booking);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return bookingRepo.save(booking);
        }
        return null;
    }

    @Override
    public void cancelBooking(Booking booking, String toEmail, String contentTitle, String message) throws MessagingException {
        if (booking.getStatus().equals("Chờ nhận phòng") || booking.getStatus().equals("Chờ xác nhận")) {
            String subject = "Thông báo hủy lịch thuê";
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
            String content = "<b>Chào bạn</b>,<br><p>" + contentTitle + ". Thông tin lịch đã đặt:</p>"
                    + "<p>- Ngôi nhà thuê: " + booking.getHouse().getName() + "</p>"
                    + "<p>- Địa chỉ: " + booking.getHouse().getAddress() + "</p>"
                    + "<p>- Khách hàng: " + booking.getAccount().getUsername() + "</p>"
                    + "<p>- Email: " + booking.getAccount().getEmail() + "</p>"
                    + "<p>- Thời gian thuê: Từ" + BillPDF.formatTime(booking.getStartTime()) + " đến " + BillPDF.formatTime(booking.getEndTime()) + "</p>"
                    + "<p>- Tổng tiền: " + numberFormat.format(booking.getTotal()) + "</p>"
                    + "<p>- Lí do hủy: " + message + "</p>";
            emailService.sendEmailBooking(subject, toEmail, content);
            booking.setStatus("Đã hủy");
            booking.setTotal(0);
            bookingRepo.save(booking);
        }
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }

    @Override
    public void save(Booking booking) {
        bookingRepo.save(booking);
    }

    @Override
    public void deleteById(int id) {
        bookingRepo.deleteById(id);
    }
    @Override
    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }
    @Override
    public List<Double> getDailyRevenueByOwnerAndWeek(int ownerId,int month,int year, int startDay,int endDay) {
        return this.getDailyRevenuesByOwnerAndWeek( ownerId, month, year,  startDay, endDay);
    }

    @Override
    public Page<Booking> findByHouseAndStartTimeAndEndTimeAndStatus(int ownerId, String nameSearch, String status, LocalDateTime startTime, LocalDateTime endTime, Pageable pageable) {
        return bookingRepo.findByHouseAndStartTimeAndEndTimeAndStatus(ownerId,nameSearch,status,startTime,endTime,pageable);
    }

    @Override
    public Review createReview(Review review) {
        review.setCreateAt(LocalDate.now());
        review.setStatus("Hiện");
        return reviewRepo.save(review);
    }

    List<Double> getDailyRevenuesByOwnerAndWeek(int ownerId, int year, int month, int startDay, int endDay) {
        List<Object[]> result = bookingRepo.getDailyRevenueByOwnerAndWeek(ownerId, year, month, startDay, endDay);
        List<Double> dailyRevenues = new ArrayList<>();
        for (int day = startDay; day <= endDay; day++) {
            boolean found = false;
            for (Object[] row : result) {
                int rowDay = (int) row[0];
                double revenue = (double) row[1];

                if (rowDay == day) {
                    dailyRevenues.add(revenue);
                    found = true;
                    break;
                }
            }
            if (!found) {
                dailyRevenues.add(0.0);
            }
        }
        return dailyRevenues;
    }

    @Override
    public Page<Booking> getByIdAccount(Pageable pageable , int idAccount) {
        return bookingRepo.getByIdAccount(pageable, idAccount);
    }

    @Override
    public Booking findById(int id) {
        return bookingRepo.findById(id);
    }

    @Override
    public SpendingDto getSpendingUser(int idAccount) {
        return bookingRepo.getSpendingUser(idAccount);
    }

    @Override
    public Page<Booking> getRentalHistoryIdAccount(Pageable pageable, int idAccount, String houseName , LocalDateTime startTime, LocalDateTime endTime, String status) {
        return bookingRepo.getHistoryRentalByIdAccount(pageable , idAccount , houseName , startTime , endTime , status);
    }
}
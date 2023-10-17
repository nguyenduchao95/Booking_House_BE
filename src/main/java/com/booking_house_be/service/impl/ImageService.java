package com.booking_house_be.service.impl;

import com.booking_house_be.entity.House;
import com.booking_house_be.entity.Image;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.repository.IImageRepo;
import com.booking_house_be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepo imageRepo;
    @Autowired
    private IHouseRepo houseRepo;
    @Override
    public List<Image> findAllByHouseId(int houseId) {
        House house = houseRepo.findById(houseId).get();
        List<Image> imageList = imageRepo.findAllByHouseId(houseId);
        List<Image> list = new ArrayList<>();
        list.add(new Image(imageList.size() + 1, house.getThumbnail()));
        list.addAll(imageList);
        return list;
    }
}

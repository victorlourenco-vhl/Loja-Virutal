package com.victor.lojavirtual.service;

import com.victor.lojavirtual.domain.Imagem;
import com.victor.lojavirtual.repository.ImagemRepository;
import com.victor.lojavirtual.util.ImagemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository rep;

    public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {

        Imagem img = new Imagem(null, file.getOriginalFilename(), file.getContentType(), ImagemUtil.compressImage(file.getBytes()));

        rep.save(img);

        return new ImageUploadResponse("Image uploaded successfully: " +
                file.getOriginalFilename());

    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = ImagemRepository.findByName(name);

        return ImageData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<ImageData> dbImage = ImagemRepository.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }

}

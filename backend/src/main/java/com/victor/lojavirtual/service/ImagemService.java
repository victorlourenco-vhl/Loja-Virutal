package com.victor.lojavirtual.service;

import com.victor.lojavirtual.domain.Imagem;
import com.victor.lojavirtual.repository.ImagemRepository;
import com.victor.lojavirtual.util.ImagemUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository rep;

    public String uploadImage(MultipartFile file) throws IOException {

        Imagem img = new Imagem(null, file.getOriginalFilename(), file.getContentType(), ImagemUtil.compressImage(file.getBytes()));

        rep.save(img);

        return "Image uploaded successfully: " +
                file.getOriginalFilename();

    }

    @Transactional
    public Imagem getInfoByImageByName(String name) {
        Optional<Imagem> img = rep.findByName(name);

        return img.get();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<Imagem> img = rep.findByName(name);
        byte[] image = ImagemUtil.decompressImage(img.get().getimageData());
        return image;
    }

}

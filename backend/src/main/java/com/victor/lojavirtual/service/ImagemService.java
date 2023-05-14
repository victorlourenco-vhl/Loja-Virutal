package com.victor.lojavirtual.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.victor.lojavirtual.domain.Imagem;
import com.victor.lojavirtual.repository.ImagemRepository;
import com.victor.lojavirtual.util.ImagemUtil;

import jakarta.transaction.Transactional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository rep;
    
    public Imagem acharPorId(Integer id) {
    	Optional<Imagem> obj = rep.findById(id);
    	return obj.orElseThrow();
    }

    public String uploadImage(MultipartFile file) throws IOException {

        Imagem img = new Imagem(null, file.getOriginalFilename(), file.getContentType(), ImagemUtil.compressImage(file.getBytes()));

        rep.save(img);

        return "Upload realizado com sucesso: " +
                file.getOriginalFilename();
        
    }
    
    @Transactional
    public byte[] acharImagemPorId(Integer id) {
    	Imagem obj = acharPorId(id);
        byte[] imagem = obj.getimageData();
        return imagem;
    }

}

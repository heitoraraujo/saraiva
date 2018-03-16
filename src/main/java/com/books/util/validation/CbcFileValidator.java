package com.books.util.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * Created by ham.heitormartins on 15/03/2018.
 */

public class CbcFileValidator<T> {

    private MultipartFile file;
    private List<T> erros = Collections.EMPTY_LIST;

    private CbcFileValidator(MultipartFile file) {
        this.file = file;
        erros = new ArrayList<T>();
    }

    public static CbcFileValidator ensureThat(MultipartFile file) {
        return new CbcFileValidator(file);
    }

    public CbcFileValidator assertMaxKiloBytes(Integer kiloBytes, T errorMessage) {
        if (hasFile() && file.getSize() > (kiloBytes * 1000)) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcFileValidator assertMaxMegaBytes(Integer megaBytes, T errorMessage) {
        if (hasFile() && file.getSize() > (megaBytes * 1000000)) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcFileValidator assertContentType(String[] contentTypes, T errorMessage) {
        if (hasFile() && !Arrays.stream(contentTypes).anyMatch(type -> type.equals(file.getContentType()))) {
            erros.add(errorMessage);
        }

        return this;
    }

    public CbcFileValidator assertImageWidth(Integer width, T errorMessage) {
        if (!hasFile()) {
            return this;
        }

        try {
            BufferedImage image = ImageIO.read(file.getInputStream());

            if (image != null && image.getWidth() != width) {
                erros.add(errorMessage);
            }
        } catch (IOException e) {
            return this;
        }

        return this;
    }

    public CbcFileValidator assertImageHeigth(Integer heigth, T errorMessage) {
        if (!hasFile()) {
            return this;
        }

        try {
            BufferedImage image = ImageIO.read(file.getInputStream());

            if (image != null && image.getHeight() != heigth) {
                erros.add(errorMessage);
            }
        } catch (IOException e) {
            return this;
        }

        return this;
    }

    public CbcFileValidator assertNotNull(T errorMessage) {
        if (!hasFile()) {
            erros.add(errorMessage);
        }

        return this;
    }

    private boolean hasFile() {
        return file != null;
    }

    public boolean hasErrors() {
        return !erros.isEmpty();
    }

    public List<T> errors() {
        return erros;
    }
}

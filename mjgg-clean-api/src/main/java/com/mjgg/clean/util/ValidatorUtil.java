package com.mjgg.clean.util;

import java.lang.reflect.Field;

public class ValidatorUtil {

    public static void validarCamposNulos(Object dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Informe todos os parâmetros");
        }

        Field[] fields = dto.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(dto);
                if (value == null) {
                    throw new IllegalArgumentException(
                        "O campo '" + field.getName() + "' não pode ser nulo"
                    );
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao acessar o campo: " + field.getName(), e);
            }
        }
    }
}

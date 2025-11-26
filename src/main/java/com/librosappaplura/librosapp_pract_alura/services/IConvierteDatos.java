package com.librosappaplura.librosapp_pract_alura.services;

public interface IConvierteDatos {
   <T> T convertdata (String json,Class<T> clase);
}

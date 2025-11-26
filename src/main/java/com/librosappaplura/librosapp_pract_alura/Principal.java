package com.librosappaplura.librosapp_pract_alura;

import com.librosappaplura.librosapp_pract_alura.model.Datos;
import com.librosappaplura.librosapp_pract_alura.model.DatosLibros;
import com.librosappaplura.librosapp_pract_alura.services.ConsumeApi;
import com.librosappaplura.librosapp_pract_alura.services.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {
    private ConsumeApi consumeApi = new ConsumeApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";
    private Scanner entrada = new Scanner(System.in);
    private final String SERCH = "?search=";

    public void menu() {
        var json = consumeApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = convierteDatos.convertdata(json, Datos.class);
        System.out.println(datos);

        //Top 10 de los libros mas descargados
        System.out.println("Top 10 de los libros mas descargados");
        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //buscar por nombre del libro
        //?search=
        System.out.println("Ingrese el libro que desea buscar: ");
        var libroBuscado = entrada.nextLine();
        var busqueda = consumeApi
                .obtenerDatos(URL_BASE + SERCH + libroBuscado.replace(" ", "+"));
        var datosDeBusqueda = convierteDatos.convertdata(busqueda, Datos.class);
        Optional<DatosLibros> librosOptional = datosDeBusqueda.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(libroBuscado.toUpperCase()))
                .findFirst();

        if (librosOptional.isPresent()) {
            System.out.println("Libro encontrado: ");
            System.out.println(librosOptional.get());
        } else {
            System.out.println("El titulo buscado no se encontro!!!");
        }
        //estadisticas
        DoubleSummaryStatistics statistics= datos.libros().stream()
                .filter(l->l.numeroDeDescargas()>0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));

        System.out.println("Cantidad media de descargas "+ statistics.getAverage());
        System.out.println("Cantidad maxima de descargas "+ statistics.getMax());
        System.out.println("Cantidad minima de descargas "+ statistics.getMin());
        System.out.println("Cantidad de registros evaluados  "+ statistics.getCount());
    }

}

package org.uma.mbd.mdTestL.tests;

import java.util.*;

public class TestAsignatura {

    private String nombre;
    private List<Test> tests;
    private double valAc, valErr;
    private static final int APROBADO = 5;

    public TestAsignatura(String n, double va, double ve, List<String> datos){
        nombre = n;
        if (va <= 0 || ve > 0)
            throw new RuntimeException("Argumentos de valor erróneos.");
        valAc = va;
        valErr = ve;
        extraeDatos(datos);
    }

    public TestAsignatura(String n, List<String> datos){
        this(n,1,0,datos);
    }

    private void extraeDatos(List<String> datos){
        tests = new ArrayList<>();
        for (String datoAlumno: datos){
            try (Scanner sc = new Scanner(datoAlumno)){
                sc.useDelimiter("[:+]");
                String n = sc.next();
                int na = sc.nextInt();
                int ne = sc.nextInt();
                Test test = new Test(nombre, na, ne);
                tests.add(test);
            }catch (InputMismatchException e){
                System.out.println("Un dato numerico no lo es en " + datoAlumno);
            }catch (NoSuchElementException e){
                System.out.println("Falta algún dato en " + datoAlumno);
            }
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int aprobados(){
        int na = 0;
        for (Test test: tests)
            if (test.calificacion(valAc,valErr) >= APROBADO)
                na++;
        return na;
    }

    public double notaMedia(){
        int na = tests.size();
        if (na == 0)
            throw new RuntimeException("No hay alumnos.");
        double suma = 0;
        for (Test test: tests)
            suma += test.calificacion(valAc, valErr);
        return suma / na;
    }

}

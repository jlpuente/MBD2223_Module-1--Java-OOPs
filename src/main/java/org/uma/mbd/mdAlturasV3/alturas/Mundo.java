package org.uma.mbd.mdAlturasV3.alturas;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Mundo {

    private List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }


    public void leePaises(String file) throws IOException {
        paises = Files.lines(Paths.get(file)).map(Mundo::stringToPais).collect(Collectors.toList());
//        for (String linea: Files.readAllLines(Paths.get(file)))
//            paises.add(stringToPais(linea));
    }

    private static Pais stringToPais(String datosPais) {
        try (Scanner scPais = new Scanner(datosPais)) {
            scPais.useDelimiter("[,]");
            scPais.useLocale(Locale.ENGLISH);
            String nombre = scPais.next();
            String continente = scPais.next();
            double altura = scPais.nextDouble();
            return new Pais(nombre, continente, altura);
        }
    }


    /*
    public List<String> getNombrePaises() {
        List<String> lista = new ArrayList<>();
        for (Pais pais: paises)
            lista.add(pais.continente());
        return lista;
    }

    public List<Pais> getPaisesDelContinente(String continente) {
        List<Pais> lista = new ArrayList<>();
        for (Pais pais: paises)
            if (pais.continente().equals(continente))
                lista.add(pais);
        return lista;
    }

    public Set<String> getContinentes() {
        Set<String> set = new TreeSet<>();
        for (Pais pais: paises) {
            set.add(pais.continente());
        }
        return set;
    }

    public boolean todosMayores(double minAltura) {
        boolean res = true;
        Iterator<Pais> it = paises.iterator();
        while (res&& it.hasNext()) {
            res = it.next().altura() >= minAltura;
        }
        return res;
    }

    public Pais masBajoDelContinente(String continente) {
        Pais menor = null;
        for (Pais pais : paises) {
            if (pais.getContinente().equals(continente)) {
                if (menor == null) {
                    menor = pais;
                } else {
                    if (menor.altura() > pais.altura()) {
                        menor = pais;
                    }
                }
            }
        }
        return menor;
    }

    public Pais paisDeMayorAltura() {
        List<Pais> otra = new ArrayList<>(paises);
        otra.sort(Comparator.comparingDouble(Pais::altura));
        return otra.get(0);
    }

    public Set<Pais> conjuntoOrdPaisesDelContinente(String continente) {
        Set<Pais> set = new TreeSet<>();
        for (Pais pais: paises) {
            if (pais.continente() .equals(continente)) {
                set.add(pais);
            }
        }
        return set;
    }


    public Map<String, List<Pais>> paisesPorContinente() {
        Map<String, List<Pais>> map = new HashMap<>();
        for (Pais pais: paises) {
            String continente = pais.continente();
            List<Pais> list = map.computeIfAbsent(continente, k -> new ArrayList<>());
            list.add(pais);
        }
        return map;
    }

    public Map<String, Set<Double>> alturasPorContinente() {
        Map<String, Set<Double>> map  = new TreeMap<>();
        for (Pais pais: paises) {
            String continente = pais.continente();
            Set<Double> set = map.computeIfAbsent(continente, k -> new HashSet<>());
            set.add(pais.altura());
        }
        return map;
    }


*/



    public List<String> getNombrePaises() {
        return paises.stream().map(Pais::nombre)
                .collect(Collectors.toList());
    }

    public List<Pais> getPaisesDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .collect(Collectors.toList());
    }

    public List<Pais> paisesDe(List<String> continentes) {
        return List.of("Europa", "Asia", "South America").stream()
                .flatMap(cont -> paises.stream().
                                    filter(p-> p.continente().equals(cont)))
                .collect(Collectors.toList());
    }

    public List<Pais> getYMuestraPaisesDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public Set<String> getContinentes() {
        return paises.stream()
                .map(Pais::continente)
                .collect(Collectors.toSet());
    }

    public List<String> getListContinentes() {
        return paises.stream()
                .map(Pais::continente)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Pais> extraeMenoresDeContinente(String continente, double maxAltura) {
            return paises.stream()
                    .filter(pais->pais.continente().equals(continente))
                    .sorted(Comparator.comparingDouble(Pais::altura))
                    .takeWhile(pais->pais.altura() < maxAltura).
                    collect(Collectors.toList());
    }

    public List<Pais> extraeMayoresDeContinente(String continente, double maxAltura) {
        return paises.stream()
                .filter(pais->pais.continente().equals(continente))
                .sorted(Comparator.comparing(Pais::altura))
                .dropWhile(pais->pais.altura() < maxAltura).
                        collect(Collectors.toList());
    }

    public void muestraNombrePaises() {
        paises.stream()
                .map(Pais::nombre)
                .forEach(System.out::println);
    }

    public boolean todosMayores(double altura) {
        return paises.stream()
                .allMatch(p -> p.altura() > altura);
    }

    public Pais masBajoDeContinente(String continente) {
        return paises.stream()
                .filter(pais->pais.continente().equals(continente))
                .sorted(Comparator.comparingDouble(Pais::altura))
                .findFirst().orElse(null);
    }

    public Pais paisMayorAltura() {
        return paises.stream()
                .max(Comparator.comparingDouble(Pais::altura))
                .get();
    }

    public long numPaisesQueVerifican(Predicate<Pais> pred) {
        return paises.stream()
                .filter(pred)
                .count();
    }

    public Pais[] arrayDePaises(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .toArray(Pais[]::new);
    }

    public double sumaAlturas() {
        return paises.stream()
                .map(Pais::altura)
                .reduce(Double::sum)
                .get();
    }

    public double suma2Alturas() {
        return paises.stream()
                .map(Pais::altura)
                .reduce(0d, Double::sum);
    }

    public double suma3Alturas() {
        return paises.stream()
                .map(Pais::altura)
                .reduce(0d, Double::sum,Double::sum);
    }

    public Set<Pais> paisesOrdDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equalsIgnoreCase(continente))
                .collect(TreeSet<Pais>::new
                        , Set::add
                        , Set::addAll);
    }

    public Set<String> paisesConColector() {
        return paises.stream()
                .map(Pais::nombre)
                .collect(new MiColector());
    }

    /*
    public Set<Double> alturasDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equals(continente))
                .collect(Collectors.mapping(Pais::altura
                        ,Collectors.toSet()));
    }
     */
    public Set<Double> alturasDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .map(Pais::altura)
                .collect(Collectors.toSet());
    }
    public long numPaisesMenoresQue(double maxAlt) {
        return paises.stream()
                .filter(p -> p.altura() < maxAlt)
                .collect(Collectors.counting());
    }

    public int numIntPaisesMenoresQue(double d) {
        return paises.stream()
                .filter(p -> p.altura() < d)
                .collect(Collectors.summingInt(pais -> 1));
    }

    public Set<String> continentesOrd() {
        return paises.stream()
                .map(Pais::continente)
                .collect(
                        Collectors.toCollection(TreeSet<String>::new));
    }

    public Map<Boolean, List<Pais>> separaPor(Predicate<Pais> pred) {
        return paises.stream()
                .collect(Collectors.partitioningBy(pred));
    }

    public Map<String, List<Pais>> paisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(Pais::continente));
    }

    public Map<String, Long> numPaisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(Pais::continente
                        ,Collectors.counting()));
    }

    public Map<String, Set<Double>> alturasPorContinente1() {
        return paises.stream()
                .collect(Collectors
                        .groupingBy(Pais::continente
                                ,Collectors.mapping(Pais::altura
                                        ,Collectors.toSet())));
    }

    public Map<String, Integer> numIntPaisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::continente
                        ,Collectors.summingInt(p -> 1)));
    }

    public Map<Double, Set<String>> continentesPorAltura() {
        return paises
                .stream()
                .collect(Collectors.groupingBy(
                        Pais::altura
                        ,Collectors.mapping(Pais::continente,
                                Collectors.toCollection(TreeSet::new))));
    }

    public Map<Double, Set<String>> continentesPorAlturaOrd() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::altura,
                        TreeMap::new,
                        Collectors.mapping(Pais::continente
                                ,Collectors.toCollection(TreeSet::new))));
    }

    public String stringDeContinentes() {
        return paises.stream()
                .map(Pais::continente)
                .distinct()
                .collect(Collectors.joining("<", ",", ">"));
    }

    public Map<String,Long>  nppl () {
        return paises.stream()
                .map(Pais::continente)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
    }

    public Map<String,Map<Double,Long>> nppccua() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::continente,
                        Collectors.groupingBy(
                                pais->((int)(pais.altura()*10))/10.0,
                                Collectors.counting())));
    }

    public Map<Double, Map<String, List<Pais>>> lppayc() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        pais -> ((int)(pais.altura()*10))/10.0,
                        Collectors.groupingBy(
                                Pais::continente)));
    }

    public Map<Long, Set<Integer>> nlpp() {
        Map<Integer, Long> map =
                paises.stream()
                        .collect(Collectors.groupingBy(pais -> pais.nombre().length(),
                                Collectors.counting()));
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        TreeMap::new,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toSet())));
    }




}

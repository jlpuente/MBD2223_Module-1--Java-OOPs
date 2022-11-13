package org.uma.mbd.mdTemas.tema4io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFile {
	public static void main(String[] str) {
		try {// Creación de un fichero en Windows
			Path p1 = Paths.get("c:\\POO\\fichero1.txt");
			Files.createFile(p1);
			// Creación de un directorio. Se admite el separador de UNIX
			Path d1 = Paths.get("c:/POO/carpeta1");
			Files.createDirectory(d1);
			// Creación de un directorio y de los directorios intermedios
			Path d3 = Paths.get("/POO/carpeta2/carpeta3");
			Files.createDirectories(d3);
			// Creación de un fichero con un directorio File
			Path f2 = Paths.get(d3.toString(), "fichero2.txt");
			Files.createFile(f2);
			// Creación de un fichero a partir de un camino relativo
			Path f3 = Paths.get("../fichero3.txt");
			Files.createFile(f3);
			// Distintas formas del camino de f3
			System.out.println(f3.getFileName());
			System.out.println(f3.normalize());
			System.out.println(f3.getNameCount());
			System.out.println(f3.getParent());
			System.out.println(f3.toAbsolutePath());
		} catch (IOException e) {
			System.out.println("ERROR: falló la creación del fichero");
		}
	}
}

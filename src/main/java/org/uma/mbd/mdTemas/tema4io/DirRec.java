package org.uma.mbd.mdTemas.tema4io;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirRec {
	public static void main(String args[]) {
		if (args.length == 0)
			System.err.println("Uso DirRec <directorio>");
		else
			new DirRec(Paths.get(args[0]));
	}

	public DirRec(Path entrada) {
		dir(entrada, 0);
	}

	private void dir(Path entrada, int n)  {
		if (!Files.exists(entrada)) {
			muestra(n, entrada + " no encontrado.");
		} else if (Files.isRegularFile(entrada)) {
			muestra(n, entrada.toString());
		} else if (Files.isDirectory(entrada)) {
			try {
				DirectoryStream<Path> files = Files.newDirectoryStream(entrada);
				muestra(n, "DIRECTORIO: " + entrada);
				for (Path f : files)
					dir(f, n + 1);
			} catch (IOException e) {
				muestra(n, entrada + " no accesible");
			}
		}
	}

	private void muestra(int n, String s) {
		for (int i = 0; i < n; i++)
			System.out.print("\t");
		System.out.println(s);
	}
}

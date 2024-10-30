package tarea7b;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class InsertarEtiquetasXMLMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			Alumno leerAlumno[] = new Alumno[5];

			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			Document document = implementation.createDocument(null, "Alumnos", null);
			document.setXmlVersion("1.0");

			Element alumnos = document.createElement("alumnos");

			for (int i = 0; i < leerAlumno.length; i++) {

				Element alumno = document.createElement("alumno");

				System.out.println("Introduzca la Nia del alumno: ");
				int niaAlumno = sc.nextInt();
				sc.nextLine();

				Element nia = document.createElement("nia");
				Text textNIA = document.createTextNode(niaAlumno + "J");
				nia.appendChild(textNIA);
				alumno.appendChild(nia);

				System.out.println("Introduzca el nombre del alumno: ");
				String nombreAlumno = sc.nextLine();

				Element nombre = document.createElement("nombre");
				Text textnombre = document.createTextNode(nombreAlumno);
				nombre.appendChild(textnombre);
				alumno.appendChild(nombre);

				System.out.println("Introduzca los apellidos del alumno: ");
				String apellidosAlumno = sc.nextLine();

				Element apellidos = document.createElement("apellidos");
				Text textapellidos = document.createTextNode(apellidosAlumno);
				apellidos.appendChild(textapellidos);
				alumno.appendChild(apellidos);

				System.out.println("Introduzca el genero del alumno: ");
				char generoAl = sc.nextLine().charAt(0);
				String generoAlumno = String.valueOf(generoAl);

				Element genero = document.createElement("genero");
				Text textgenero = document.createTextNode(generoAlumno);
				genero.appendChild(textgenero);
				alumno.appendChild(genero);

				System.out.println("Introduzca la fecha de nacimiento del alumno(yyyy-MM-dd): ");
				String fechaNacimientoAlumno = sc.nextLine();
				LocalDate nacimientoAlumno = LocalDate.parse(fechaNacimientoAlumno);

				Element fechaNacimiento = document.createElement("fechaNacimiento");
				Text textfechaNacimiento = document.createTextNode(fechaNacimientoAlumno);
				fechaNacimiento.appendChild(textfechaNacimiento);
				alumno.appendChild(fechaNacimiento);

				System.out.println("Introduzca el cliclo del alumno: ");
				String cicloAlumno = sc.nextLine();

				Element ciclo = document.createElement("ciclo");
				Text textciclo = document.createTextNode(cicloAlumno);
				ciclo.appendChild(textciclo);
				alumno.appendChild(ciclo);

				System.out.println("Introduzca el curso del alumno: ");
				String cursoAlumno = sc.nextLine();

				Element curso = document.createElement("curso");
				Text textcurso = document.createTextNode(cursoAlumno);
				curso.appendChild(textcurso);
				alumno.appendChild(curso);

				System.out.println("Introduzca el grupo del alumno: ");
				String grupoAlumno = sc.nextLine();

				Element grupo = document.createElement("grupo");
				Text textgrupo = document.createTextNode(grupoAlumno);
				grupo.appendChild(textgrupo);
				alumno.appendChild(grupo);

				alumnos.appendChild(alumno);
			}

			document.getDocumentElement().appendChild(alumnos);

			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("alumnosEtiquetas.xml"));

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (TransformerException a) {
			a.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
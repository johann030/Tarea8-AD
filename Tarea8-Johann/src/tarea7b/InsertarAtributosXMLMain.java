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

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InsertarAtributosXMLMain extends InsertarEtiquetasXMLMain{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			Alumno leerAlumno[] = new Alumno[5];

			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			Document document = implementation.createDocument(null, "Alumnos", null);
			document.setXmlVersion("1.0");

			Element alumnos = document.createElement("AlumnosAtributos");

			for (int i = 0; i < leerAlumno.length; i++) {
				
				Element alumno = document.createElement("alumno");
				
				System.out.println("Introduzca la Nia del alumno: ");
				int niaAlumno = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca el nombre del alumno: ");
				String nombreAlumno = sc.nextLine();

				System.out.println("Introduzca los apellidos del alumno: ");
				String apellidosAlumno = sc.nextLine();

				System.out.println("Introduzca el genero del alumno: ");
				char generoAl = sc.nextLine().charAt(0);
				String generoAlumno = String.valueOf(generoAl);

				System.out.println("Introduzca la fecha de nacimiento del alumno(yyyy-MM-dd): ");
				String fechaNacimientoAlumno = sc.nextLine();
				LocalDate nacimientoAlumno = LocalDate.parse(fechaNacimientoAlumno);

				System.out.println("Introduzca el cliclo del alumno: ");
				String cicloAlumno = sc.nextLine();

				System.out.println("Introduzca el curso del alumno: ");
				String cursoAlumno = sc.nextLine();

				System.out.println("Introduzca el grupo del alumno: ");
				String grupoAlumno = sc.nextLine();

				Attr nia = document.createAttribute("nia");
				nia.setValue(niaAlumno + "J");
				alumno.setAttributeNode(nia);

				Attr nombre = document.createAttribute("nombre");
				nombre.setValue(nombreAlumno);
				alumno.setAttributeNode(nombre);

				Attr apellidos = document.createAttribute("apellidos");
				apellidos.setValue(apellidosAlumno);
				alumno.setAttributeNode(apellidos);

				Attr genero = document.createAttribute("genero");
				genero.setValue(generoAlumno);
				alumno.setAttributeNode(genero);

				Attr fechaNacimiento = document.createAttribute("fechaNacimiento");
				fechaNacimiento.setValue(fechaNacimientoAlumno);
				alumno.setAttributeNode(fechaNacimiento);

				Attr ciclo = document.createAttribute("ciclo");
				ciclo.setValue(cicloAlumno);
				alumno.setAttributeNode(ciclo);

				Attr curso = document.createAttribute("curso");
				curso.setValue(cursoAlumno);
				alumno.setAttributeNode(curso);

				Attr grupo = document.createAttribute("grupo");
				grupo.setValue(grupoAlumno);
				alumno.setAttributeNode(grupo);

				alumnos.appendChild(alumno);

			}
			document.getDocumentElement().appendChild(alumnos);

			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("alumnosAtributos.xml"));

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

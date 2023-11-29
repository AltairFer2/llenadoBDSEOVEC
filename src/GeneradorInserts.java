import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorInserts {

    private static String[] nombres = { "Pepe", "Luis", "Fernando", "Miguel", "Gerardo", "Antonio", "Ángel", "David",
            "Leonardo", "Alejandro", "Víctor", "Alma", "Gabriela", "Andrea", "Marisol", "Luna", "Almanza", "Jairo",
            "Fátima", "Noemi", "Ana", "Rosa", "Carolina", "Karla", "Carla", "Mía", "Jocelyn", "Gisel", "Karina",
            "Yosef", "Martha", "Camila", "Esther", "Samantha", "Luisa", "María", "Guadalupe", "Dulce" };
    private static String[] apellidos = { "López", "Rodríguez", "Sánchez", "Alvarado", "Vera", "Franco", "García",
            "Vázquez", "Cervantes", "Flores", "Torres", "Arellano", "Monte Negro", "Torrecillas", "Cortez", "León",
            "Bolaños", "Montecillo", "Gómez", "Palacios", "Anguiano", "Cabañas", "Prieto", "Aguilar", "Peasland",
            "Rayón", "Colesio", "Maldonado" };
    private static String[] contrasenas = { "root", "admin", "1234", "user", "Administrator", "administrador", "12345",
            "123456", "anonymous", "Anonymous", "admini", "zzzzz", "zxm10", "zxcxz", "zxcvbnm!@#$%^&", "zxcvbn",
            "zxcvb", "zxccxz", "zj!@#$%^&", "zhang123", "zhang", "zaqxswcdevfr", "zaqxswcde1472583", "zaqxswcde",
            "zaq1xsw2", "zaq12wsx", "z1x2c3v4", "xxxxxx", "xxxxx", "xiaozhe", "xiaolin82", "www-data", "www.999.com" };
    private static String[] fechasNacimiento = { "1980-01-01", "1982-03-15", "1985-07-22", "1988-11-05", "1990-09-12",
            "1993-12-18", "1997-02-28", "2000-04-10", "2005-06-23", "2010-12-31" };
    private static String[] correos = { "A1@gmail.com", "B2@gmail.com", "C3@gmail.com", "D4@gmail.com", "E5@gmail.com",
            "F6@gmail.com", "G7@gmail.com", "H8@gmail.com", "I9@gmail.com", "J10@gmail.com" };
    private static int[] idCatalogoUsuarios = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
    private static long[] telefonos = { 5551112233L, 5552223344L, 5553334455L, 5554445566L, 5555556677L, 5556667788L,
            5557778899L, 5558889900L, 5559990011L, 5550001122L };

    private static int[] idCatalogoPerfiles = { 1, 2, 3 };
    private static int[] idFeedbacks = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

    public static void main(String[] args) {
        try {
            generarInserts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generarInserts() throws IOException {
        // Pregunta al usuario la cantidad de inserts
        int cantidadInserts = pedirCantidadInserts();

        // Elimina el archivo si ya existe
        eliminarArchivoSiExiste();

        // Genera los inserts y los escribe en un archivo
        generarYGuardarInserts(cantidadInserts);

        // Muestra un mensaje de éxito
        JOptionPane.showMessageDialog(null,
                "Inserts generados exitosamente. Verifica el archivo en C:\\Prueba\\inserts.txt");
    }

    private static void eliminarArchivoSiExiste() {
        File file = new File("C:\\Prueba\\inserts.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    private static void generarYGuardarInserts(int cantidad) throws IOException {
        // Abre un archivo para escribir los inserts
        FileWriter writer = new FileWriter("C:\\Prueba\\inserts.txt", true); // true indica que se añadirá al final del
                                                                             // archivo

        // Genera e escribe los inserts para la tabla 'usuario' en el archivo
        for (int i = 0; i < cantidad; i++) {
            String insertUsuario = generarInsertAleatorio();
            writer.write(insertUsuario + "\n");
        }

        // Genera e escribe los inserts para la tabla 'cuestionario' en el archivo
        String[] preguntas = {
                "¿Qué actividades o pasatiempos disfrutas hacer en tu tiempo libre?",
                "¿Cuáles son tus habilidades y talentos naturales?",
                "¿Qué temas o áreas de conocimiento te interesan profundamente?",
                "¿Qué tipo de tareas o trabajos te hacen sentir más realizado/a?",
                "¿Cuáles son tus valores personales y principios?",
                "¿Qué tipo de ambiente de trabajo te resulta más cómodo y satisfactorio?",
                "¿Cuál es tu estilo de aprendizaje preferido?",
                "¿Te gustaría trabajar de manera independiente o en equipo?",
                "¿Cómo te ves a ti mismo/a contribuyendo a la sociedad o al mundo?",
                "¿Eres una persona perseverante?",
                "¿Eres una persona paciente?",
                "¿Eres una persona con habilidades verbales?",
                "¿Eres una persona con habilidades administrativas?",
                "¿Eres una persona con habilidades de programación?",
                "¿Puedes dirigir la fabricación, instalación y pruebas de equipos eléctricos?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la complejidad de la disciplina de ingeniería en electrónica?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la fiabilidad?",
                "¿Tienes un pensamiento matemático-lógico sólido?",
                "¿Qué tan hábil eres para la tecnología?",
                "¿Tienes experiencia práctica?",
                "¿Eres hábil comunicándote de forma asertiva?",
                "¿Eres alguien perseverante?",
                "¿Eres alguien paciente?",
                "¿Eres una persona con habilidades verbales?",
                "¿Eres una persona con habilidades administrativas?",
                "¿Eres una persona con habilidades de programación?",
                "¿Puedes dirigir la fabricación, instalación y pruebas de equipos eléctricos?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la complejidad de la disciplina de ingeniería en electrónica?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la fiabilidad?",
                "¿Tienes un pensamiento matemático-lógico sólido?",
                "¿Disfrutas resolver problemas complejos?",
                "¿Qué tanto te cuesta tomar decisiones?",
                "¿Qué tan bueno eres gestionando tu tiempo?",
                "¿Qué tan bueno eres estableciendo tus prioridades?",
                "¿Qué tan bueno eres para comprender cómo funcionan las organizaciones?",
                "¿Eres alguien analítico?",
                "¿Eres alguien versátil?",
                "¿Qué tan hábil eres para el pensamiento matemático?",
                "¿Qué tan hábil eres para la tecnología?",
                "¿Tienes experiencia práctica?",
                "¿Eres hábil comunicándote de forma asertiva?",
                "¿Eres alguien perseverante?",
                "¿Eres alguien paciente?",
                "¿Eres una persona con habilidades verbales?",
                "¿Eres una persona con habilidades administrativas?",
                "¿Eres una persona con habilidades de programación?",
                "¿Puedes dirigir la fabricación, instalación y pruebas de equipos eléctricos?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la complejidad de la disciplina de ingeniería en electrónica?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la fiabilidad?",
                "¿Tienes un pensamiento matemático-lógico sólido?",
                "¿Disfrutas resolver problemas complejos?",
                "¿Qué tanto te cuesta tomar decisiones?",
                "¿Qué tan bueno eres gestionando tu tiempo?",
                "¿Qué tan bueno eres estableciendo tus prioridades?",
                "¿Qué tan bueno eres para comprender cómo funcionan las organizaciones?",
                "¿Eres alguien analítico?",
                "¿Eres alguien versátil?",
                "¿Qué tan hábil eres para el pensamiento matemático?",
                "¿Qué tan hábil eres para la tecnología?",
                "¿Tienes experiencia práctica?",
                "¿Eres hábil comunicándote de forma asertiva?",
                "¿Eres alguien perseverante?",
                "¿Eres alguien paciente?",
                "¿Eres una persona con habilidades verbales?",
                "¿Eres una persona con habilidades administrativas?",
                "¿Eres una persona con habilidades de programación?",
                "¿Puedes dirigir la fabricación, instalación y pruebas de equipos eléctricos?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la complejidad de la disciplina de ingeniería en electrónica?",
                "¿Te preocupa la falta de seguridad?",
                "¿Te preocupa la fiabilidad?",
                "¿Tienes un pensamiento matemático-lógico sólido?"
        };

        for (int i = 0; i < preguntas.length; i++) {
            String insertCuestionario = String.format("INSERT INTO cuestionario (pregunta) VALUES ('%s');",
                    preguntas[i]);
            writer.write(insertCuestionario + "\n");
        }

        // Genera e escribe los inserts para la tabla 'respuesta' en el archivo
        String[] respuestas = {
                "a) Pasatiempos relacionados con la fotografía y la edición de imágenes, lo que me hace considerar una carrera en diseño gráfico o fotografía.",
                "b) Disfruto resolviendo problemas matemáticos y lógicos, y me gustaría explorar carreras en matemáticas, ingeniería o ciencias de la computación.",
                "c) Me apasiona aprender sobre diferentes culturas, idiomas y geografía, lo que me lleva a considerar carreras en estudios internacionales, turismo o traducción.",
                "d) Mi interés por la biología, la química y la investigación científica me hace pensar en carreras en biología, medicina o química.",
                "e) Me encanta la escritura creativa, la literatura y expresar ideas a través de las palabras, lo que me hace considerar carreras en escritura, periodismo o publicidad.",
                "f) Tengo una fuerte conexión con la tecnología, la programación y la creación de software, lo que me lleva a considerar carreras en informática, desarrollo de software o ingeniería informática.",
                "g) Me siento atraído por el arte, la música y la expresión creativa, lo que me hace pensar en carreras en bellas artes, música o diseño artístico.",
                "h) Disfruto enseñando y ayudando a otros a aprender, lo que me lleva a considerar carreras en educación, formación o tutoría.",
                "i) Me interesan los temas sociales, la justicia y hacer del mundo un lugar mejor, lo que me hace considerar carreras en trabajo social, derechos humanos o ciencias políticas.",
                "j) Me gusta trabajar con números, analizar datos y tomar decisiones basadas en información, lo que me lleva a considerar carreras en estadísticas, análisis de datos o finanzas.",
                "k) Me atraen los deportes, la actividad física y la promoción de un estilo de vida saludable, lo que me hace considerar carreras en deportes, fisioterapia o nutrición.",
                "l) Me fascina el mundo del entretenimiento, el cine y la producción audiovisual, lo que me lleva a considerar carreras en cine, televisión o producción multimedia.",
                "m) Me siento atraído por la arquitectura, el diseño de espacios y la creación de entornos visuales, lo que me hace considerar carreras en arquitectura o diseño de interiores.",
                "n) Mi interés por la política, la toma de decisiones y la gestión me hace pensar en carreras en administración pública, gestión empresarial o ciencias políticas.",
                "o) Disfruto explorando y comprendiendo el mundo natural que me rodea, lo que me lleva a considerar carreras en geología, medio ambiente o ciencias ambientales.",
                "p) Me apasiona la psicología, entender la mente humana y ayudar a otros en su bienestar mental, lo que me hace considerar carreras en psicología o psiquiatría.",
                "q) Mi interés por la moda, el diseño de prendas y la industria textil me hace pensar en carreras en moda, diseño de moda o merchandising.",
                "r) Tengo habilidades para la organización, la planificación y la gestión del tiempo, lo que me lleva a considerar carreras en gestión de eventos, planificación de proyectos o administración.",
                "s) Me gusta la resolución de problemas y la programación, considero carreras en ingeniería de software o ciencias de la computación.",
                "t) Mi interés por la inteligencia artificial y el aprendizaje automático me hace considerar carreras en investigación y desarrollo en el campo de la IA.",
                "u) Me atrae el ámbito de la salud y el bienestar, considero carreras en medicina, enfermería o terapia física.",
                "v) Disfruto explorando y entendiendo el comportamiento humano, considero carreras en sociología, antropología o investigación social.",
                "w) Mi pasión por los idiomas y la comunicación me lleva a considerar carreras en lingüística, interpretación o traducción.",
                "x) Me interesa la ciberseguridad, la protección de datos y la prevención de ciberataques, considero carreras en seguridad informática o ciberseguridad.",
                "y) Tengo habilidades para la gestión financiera y la toma de decisiones económicas, considero carreras en finanzas, contabilidad o análisis económico.",
                "z) Me atrae el diseño de productos y la innovación, considero carreras en diseño industrial, ingeniería de productos o desarrollo de productos.",
                "aa) Mi interés por la investigación histórica y la comprensión de eventos pasados me lleva a considerar carreras en historia, arqueología o investigación histórica.",
                "ab) Disfruto creando contenido visual atractivo, considero carreras en diseño gráfico, animación o medios visuales.",
                "ac) Me apasiona la música y tengo habilidades en la interpretación musical, considero carreras en música, composición o interpretación musical.",
                "ad) Mi interés por la alimentación saludable y el bienestar me lleva a considerar carreras en nutrición, dietética o ciencias de la alimentación.",
                "ae) Tengo habilidades para la negociación y la comunicación, lo que me hace considerar carreras en ventas, marketing o relaciones públicas.",
                "af) Me gusta trabajar con tecnologías emergentes y explorar nuevas soluciones, considero carreras en investigación y desarrollo de tecnologías.",
                "ag) Mi interés por la sostenibilidad y la responsabilidad ambiental me lleva a considerar carreras en sostenibilidad, energías renovables o gestión ambiental.",
                "ah) Me atrae el mundo del teatro, la actuación y la expresión artística, considero carreras en teatro, actuación o dirección escénica.",
                "ai) Disfruto del trabajo en equipo y tengo habilidades para liderar, considero carreras en gestión de equipos, liderazgo empresarial o emprendimiento.",
                "aj) Mi interés por la moda sostenible y ética me lleva a considerar carreras en moda sostenible, diseño ético o gestión sostenible.",
                "ak) Me gusta explorar nuevas culturas a través de la gastronomía, considero carreras en gastronomía, chef o gestión de restaurantes.",
                "al) Mi pasión por la innovación y la creación de soluciones me lleva a considerar carreras en emprendimiento, desarrollo de negocios o innovación.",
                "am) Me atraen las ciencias sociales y la comprensión de la sociedad, considero carreras en sociología, ciencias políticas o trabajo social.",
                "an) Tengo habilidades para la organización de eventos y la planificación, considero carreras en organización de eventos, planificación de reuniones o gestión de eventos.",
                "ao) Me gusta trabajar con datos y encontrar patrones, considero carreras en análisis de datos, ciencia de datos o inteligencia de negocios.",
                "ap) Mi interés por la moda y la expresión personal a través de la ropa me lleva a considerar carreras en estilismo, diseño de moda o asesoría de imagen.",
                "aq) Disfruto de la resolución de problemas en el ámbito tecnológico, considero carreras en ingeniería de software, desarrollo web o seguridad informática.",
                "ar) Me apasiona el diseño de espacios y la creación de entornos visuales, considero carreras en arquitectura, diseño de interiores o planificación urbana.",
                "as) Tengo habilidades para la gestión financiera y me interesa el mundo de las inversiones, considero carreras en finanzas, banca o análisis financiero.",
                "at) Me atrae la investigación científica y el descubrimiento de nuevos conocimientos, considero carreras en investigación científica, biología molecular o física.",
                "au) Mi interés por la psicología y el bienestar mental me lleva a considerar carreras en psicología clínica, terapia psicológica o psiquiatría.",
                "av) Disfruto de la creación de contenidos visuales atractivos, considero carreras en diseño gráfico, animación o producción multimedia.",
                "aw) Me apasiona la música y tengo habilidades en la composición musical, considero carreras en música, composición o producción musical.",
                "ax) Mi interés por la alimentación y la salud me lleva a considerar carreras en nutrición, dietética o ciencias de la alimentación.",
                "ay) Tengo habilidades para la comunicación y la negociación, considero carreras en ventas, marketing o relaciones públicas.",
                "az) Me atrae la investigación y desarrollo de tecnologías emergentes, considero carreras en investigación y desarrollo de tecnologías, innovación tecnológica o ingeniería de última generación.",
                "ba) Mi interés por la sostenibilidad y el medio ambiente me lleva a considerar carreras en sostenibilidad, energías renovables o gestión ambiental.",
                "bb) Me gusta el teatro y la expresión artística a través de la actuación, considero carreras en teatro, actuación o dirección escénica.",
                "bc) Disfruto del trabajo en equipo y tengo habilidades para liderar, considero carreras en gestión de equipos, liderazgo empresarial o emprendimiento.",
                "bd) Mi interés por la moda sostenible y ética me lleva a considerar carreras en moda sostenible, diseño ético o gestión sostenible.",
                "be) Me gusta explorar nuevas culturas a través de la gastronomía, considero carreras en gastronomía, chef o gestión de restaurantes.",
                "bf) Mi pasión por la innovación y la creación de soluciones me lleva a considerar carreras en emprendimiento, desarrollo de negocios o innovación.",
                "bg) Me atraen las ciencias sociales y la comprensión de la sociedad, considero carreras en sociología, ciencias políticas o trabajo social.",
                "bh) Tengo habilidades para la organización de eventos y la planificación, considero carreras en organización de eventos, planificación de reuniones o gestión de eventos.",
                "bi) Me gusta trabajar con datos y encontrar patrones, considero carreras en análisis de datos, ciencia de datos o inteligencia de negocios.",
                "bj) Mi interés por la moda y la expresión personal a través de la ropa me lleva a considerar carreras en estilismo, diseño de moda o asesoría de imagen.",
                "bk) Disfruto de la resolución de problemas en el ámbito tecnológico, considero carreras en ingeniería de software, desarrollo web o seguridad informática.",
                "bl) Me apasiona el diseño de espacios y la creación de entornos visuales, considero carreras en arquitectura, diseño de interiores o planificación urbana.",
                "bm) Tengo habilidades para la gestión financiera y me interesa el mundo de las inversiones, considero carreras en finanzas, banca o análisis financiero.",
                "bn) Me atrae la investigación científica y el descubrimiento de nuevos conocimientos, considero carreras en investigación científica, biología molecular o física.",
                "bo) Mi interés por la psicología y el bienestar mental me lleva a considerar carreras en psicología clínica, terapia psicológica o psiquiatría.",
                "bp) Disfruto de la creación de contenidos visuales atractivos, considero carreras en diseño gráfico, animación o producción multimedia.",
                "bq) Me apasiona la música y tengo habilidades en la composición musical, considero carreras en música, composición o producción musical.",
                "br) Mi interés por la alimentación y la salud me lleva a considerar carreras en nutrición, dietética o ciencias de la alimentación.",
                "bs) Tengo habilidades para la comunicación y la negociación, considero carreras en ventas, marketing o relaciones públicas.",
                "bt) Me atrae la investigación y desarrollo de tecnologías emergentes, considero carreras en investigación y desarrollo de tecnologías, innovación tecnológica o ingeniería de última generación.",
                "bu) Mi interés por la sostenibilidad y el medio ambiente me lleva a considerar carreras en sostenibilidad, energías renovables o gestión ambiental.",
                "bv) Me gusta el teatro y la expresión artística a través de la actuación, considero carreras en teatro, actuación o dirección escénica.",
                "bw) Disfruto del trabajo en equipo y tengo habilidades para liderar, considero carreras en gestión de equipos, liderazgo empresarial o emprendimiento.",
                "bx) Mi interés por la moda sostenible y ética me lleva a considerar carreras en moda sostenible, diseño ético o gestión sostenible.",
        };

        for (int i = 0; i < respuestas.length; i++) {
            String insertRespuesta = String.format("INSERT INTO respuesta (id_respuesta, respuesta) VALUES (%d, '%s');",
                    i + 1, respuestas[i]);
            writer.write(insertRespuesta + "\n");
        }

        // Cierra el archivo
        writer.close();
    }

    private static int pedirCantidadInserts() {
        String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de inserts que desea generar:");
        try {
            return Integer.parseInt(cantidad);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            return pedirCantidadInserts();
        }
    }

    private static String generarInsertAleatorio() {
        Random random = new Random();

        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido = apellidos[random.nextInt(apellidos.length)];
        String contrasena = contrasenas[random.nextInt(contrasenas.length)];
        String fechaNacimiento = fechasNacimiento[random.nextInt(fechasNacimiento.length)];
        String correo = correos[random.nextInt(correos.length)];
        int idCatalogoUsuario = idCatalogoUsuarios[random.nextInt(idCatalogoUsuarios.length)];
        long telefono = telefonos[random.nextInt(telefonos.length)];
        int idCatalogoPerfil = idCatalogoPerfiles[random.nextInt(idCatalogoPerfiles.length)];
        int idFeedback = idFeedbacks[random.nextInt(idFeedbacks.length)];

        return String.format("INSERT INTO usuario (nombre, apellido, contrasena, fecha_nacimiento, correo, " +
                "id_catalogo_usuario, telefono, id_catalogo_perfil, id_feedback) VALUES ('%s', '%s', '%s', '%s', '%s', %d, %d, %d, %d);",
                nombre, apellido, contrasena, fechaNacimiento, correo, idCatalogoUsuario, telefono, idCatalogoPerfil,
                idFeedback);
    }

}

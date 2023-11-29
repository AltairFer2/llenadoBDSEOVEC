import javax.swing.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorInserts {
    private static String[] nombres = { "Pepe", "Luis", "Fernando", "Miguel", "Gerardo", "Antonio", "Angel", "David",
            "Leonardo", "Alejandro", "Victor", "Alma", "Gabriela", "Andrea", "Marisol", "Luna", "Almanza", "Jairo",
            "Fatima", "Noemi", "Ana", "Rosa", "Carolina", "Karla", "Carla", "Mía", "Jocelyn", "Gisel", "Karina",
            "Yosef", "Martha", "Camila", "Esther", "Samantha", "Luisa", "Maria", "Guadalupe", "Dulce" };
    private static String[] apellidos = { "Lopez", "Rodriguez", "Sanchez", "Alvarado", "Vera", "Franco", "Garcia",
            "Vazquez", "Cervantes", "Flores", "Torres", "Arellano", "Monte Negro", "Torrecillas", "Cortez", "Leon",
            "Bolanos", "Montecillo", "Gomez", "Palacios", "Anguiano", "Cabañas", "Prieto", "Aguilar", "Peasland",
            "Rayon", "Colesio", "Maldonado" };
    private static String[] contrasenas = { "root", "admin", "1234", "user", "Administrator", "administrador", "12345",
            "123456", "anonymous", "Anonymous", "admini", "zzzzz", "zxm10", "zxcxz", "zxcvbnm!@#$%^&", "zxcvbn",
            "zxcvb", "zxccxz", "zj!@#$%^&", "zhang123", "zhang", "zaqxswcdevfr", "zaqxswcde1472583", "zaqxswcde",
            "zaq1xsw2", "zaq12wsx", "z1x2c3v4", "xxxxxx", "xxxxx", "xiaozhe", "xiaolin82", "www-data", "www.999.com" };
    private static String[] fechasNacimiento = { "1980-01-01", "1982-03-15", "1985-07-22", "1988-11-05", "1990-09-12",
            "1993-12-18", "1997-02-28", "2000-04-10", "2005-06-23", "2010-12-31" };
    private static String[] correos = { "A1@gmail.com", "B2@gmail.com", "C3@gmail.com", "D4@gmail.com", "E5@gmail.com",
            "F6@gmail.com", "G7@gmail.com", "H8@gmail.com", "I9@gmail.com", "J10@gmail.com" };
    private static int[] idCatalogoUsuarios = { 1, 2 };
    private static long[] telefonos = { 5551112233L, 5552223344L, 5553334455L, 5554445566L, 5555556677L, 5556667788L,
            5557778899L, 5558889900L, 5559990011L, 5550001122L };

    private static int[] idCatalogoPerfiles = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

    private static String[] comentarios = {
            "Me encanta este sistema, me ayudó a descubrir mis intereses y habilidades.",
            "Es muy fácil de usar y proporciona información detallada sobre diferentes carreras.",
            "Gracias a este sistema, ahora tengo una dirección clara para mi futuro profesional.",
            "Me ayudó a explorar opciones que nunca había considerado antes.",
            "Las pruebas de personalidad fueron precisas y útiles.",
            "Este sistema es esencial para cualquier persona que esté indecisa sobre su carrera.",
            "Me proporcionó valiosos recursos para investigar más sobre las carreras que me interesan.",
            "La interfaz es intuitiva y fácil de navegar.",
            "Recibí orientación personalizada basada en mis respuestas.",
            "Es una herramienta valiosa para estudiantes en transición de la escuela secundaria a la universidad.",
            "Ofrece consejos prácticos para la planificación de la carrera.",
            "El sistema tiene una amplia base de datos de información sobre profesiones.",
            "Me ayudó a comprender mis fortalezas y debilidades en términos de habilidades laborales.",
            "Es genial para descubrir carreras que se alinean con mis pasiones.",
            "Las evaluaciones de intereses son muy acertadas.",
            "Me brindó confianza al tomar decisiones sobre mi futuro académico y profesional.",
            "El sistema considera aspectos prácticos como la demanda laboral y las perspectivas de salario.",
            "Las recomendaciones personalizadas fueron precisas y útiles.",
            "Me hizo reflexionar sobre lo que realmente quiero en una carrera.",
            "Una herramienta esencial para estudiantes que buscan orientación profesional.",
            "Ofrece información detallada sobre el mercado laboral actual.",
            "Los informes de resultados son fáciles de entender y proporcionan información valiosa.",
            "Este sistema marcó la diferencia en mi toma de decisiones sobre la carrera.",
            "Fue una experiencia enriquecedora que me ayudó a conocerme mejor.",
            "La variedad de pruebas y evaluaciones cubre todos los aspectos importantes.",
            "Me brindó claridad en un momento en que estaba confundido sobre mi futuro profesional.",
            "Las recomendaciones fueron específicas y adaptadas a mis intereses.",
            "Este sistema debería implementarse en todas las escuelas.",
            "Una herramienta invaluable para planificar una carrera a largo plazo.",
            "Es una guía efectiva para descubrir vocaciones alineadas con mi personalidad.",
            "Me proporcionó información útil sobre las habilidades requeridas en diferentes campos.",
            "La retroalimentación detallada me ayudó a entender mis preferencias profesionales.",
            "Fue una experiencia reflexiva que me llevó a considerar nuevas posibilidades.",
            "Me ayudó a establecer metas realistas para mi futuro profesional.",
            "Las recomendaciones de carreras coincidieron con mis intereses y valores.",
            "Este sistema hizo que la planificación de la carrera fuera emocionante y no abrumadora.",
            "Las pruebas de habilidades fueron útiles para identificar áreas de mejora.",
            "Me proporcionó una visión clara de cómo mis habilidades pueden aplicarse en el mundo laboral.",
            "Las entrevistas virtuales de práctica fueron una adición útil.",
            "Me dio la confianza para explorar carreras que nunca había considerado antes.",
            "Ofrece recursos informativos sobre programas educativos y capacitación.",
            "La guía paso a paso facilita la navegación por el proceso de toma de decisiones.",
            "Me proporcionó una visión realista de lo que implica cada carrera.",
            "Las evaluaciones de valores fueron esenciales para alinear mi carrera con mis creencias.",
            "Fue una experiencia educativa que cambió mi perspectiva sobre las opciones profesionales.",
            "Este sistema me dio la confianza para perseguir una carrera que realmente amo.",
            "Las opciones de carrera recomendadas fueron diversas y emocionantes.",
            "Es una herramienta valiosa para explorar carreras emergentes y en crecimiento.",
            "Las sugerencias de desarrollo profesional fueron perspicaces y aplicables.",
            "Me proporcionó información sobre oportunidades de trabajo en el extranjero.",
            "Las evaluaciones de habilidades blandas fueron una adición valiosa.",
            "Este sistema me inspiró a considerar carreras que están en demanda actualmente.",
            "Las herramientas de exploración de carreras fueron intuitivas y esclarecedoras.",
            "Fue una guía esencial durante mi transición de la educación secundaria a la universidad.",
            "Me dio confianza al tomar decisiones importantes sobre mi futuro.",
            "Las recomendaciones de carrera se ajustaron a mis metas a largo plazo.",
            "Este sistema me ayudó a identificar mis pasiones y convertirlas en una carrera.",
            "Me proporcionó recursos para investigar programas de estudio específicos.",
            "Las pruebas de aptitud fueron una herramienta útil para evaluar mis habilidades.",
            "Fue una experiencia educativa valiosa que contribuyó a mi desarrollo personal.",
            "Me ayudó a entender cómo mis intereses pueden traducirse en opciones de carrera.",
            "Las evaluaciones de personalidad fueron sorprendentemente precisas.",
            "Me proporcionó información valiosa sobre el crecimiento proyectado en diferentes industrias.",
            "Las recomendaciones de educación continua fueron útiles para planificar mi desarrollo profesional.",
            "Este sistema hizo que el proceso de toma de decisiones sobre la carrera fuera emocionante.",
            "Me brindó una visión completa de las oportunidades laborales en mi campo de interés.",
            "Fue una guía esencial para navegar por las opciones educativas y profesionales.",
            "Las evaluaciones de fortalezas y debilidades fueron esclarecedoras y motivadoras.",
            "Me ayudó a conectar mis intereses con carreras específicas y alcanzables.",
            "Las entrevistas simuladas me dieron confianza para enfrentar futuras entrevistas reales.",
            "Este sistema hizo que el proceso de exploración de carreras fuera emocionante.",
            "Me proporcionó información esencial sobre la formación necesaria para diferentes profesiones.",
            "Las evaluaciones de compatibilidad con el trabajo en equipo fueron esenciales.",
            "Fue una herramienta valiosa para identificar oportunidades de crecimiento en mi campo.",
            "Me dio una perspectiva clara de las diferentes etapas de una carrera.",
            "Las evaluaciones de satisfacción laboral fueron informativas y reveladoras.",
            "Me proporcionó una lista detallada de habilidades necesarias para mi campo de interés.",
            "Este sistema es esencial para estudiantes que buscan una educación superior bien informada.",
            "Las sugerencias de desarrollo profesional fueron adaptadas a mis metas individuales.",
            "Me ayudó a identificar carreras que alinean con mis valores y ética personal.",
            "Las pruebas de compatibilidad con la cultura organizativa fueron útiles para elegir empresas.",
            "Fue una experiencia enriquecedora que contribuyó a mi autoconocimiento.",
            "Me proporcionó información sobre oportunidades de trabajo remoto.",
            "Las evaluaciones de gestión del tiempo fueron prácticas y aplicables.",
            "Este sistema me dio confianza para explorar campos que desconocía anteriormente.",
            "Me proporcionó recursos para encontrar programas de capacitación específicos.",
            "Las sugerencias de carreras alternativas fueron valiosas para considerar diferentes caminos.",
            "Fue una herramienta esencial para planificar una educación superior centrada en la carrera.",
            "Me dio una comprensión detallada de las expectativas laborales en diferentes campos.",
            "Las evaluaciones de liderazgo fueron esclarecedoras y motivadoras.",
            "Este sistema me brindó una guía paso a paso para explorar opciones de carrera.",
            "Me ayudó a entender cómo mis valores personales pueden influir en mi elección de carrera.",
            "Las pruebas de adaptabilidad fueron útiles para evaluar mi capacidad para enfrentar cambios.",
            "Fue una experiencia educativa que preparó adecuadamente para mi futura carrera.",
            "Me proporcionó información detallada sobre las habilidades requeridas en la industria actual.",
            "Las evaluaciones de ética laboral fueron esenciales para alinear mi carrera con mis valores.",
            "Este sistema me brindó recursos para explorar programas académicos específicos.",
            "Me ayudó a considerar opciones de carrera que no habría explorado por mi cuenta.",
            "Las sugerencias de desarrollo personal fueron motivadoras y aplicables.",
            "Fue una herramienta esencial para tomar decisiones informadas sobre mi educación superior."
    };

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
        String[] carrera = {
                "Lic. En Arquitectura",
                "Lic. En Administración",
                "Ing. Ambiental",
                "Ing. Bioquímica",
                "Ing. Electrónica",
                "Ing. En Gestión Empresarial",
                "Ing. Mecánica",
                "Ing. Mecatrónica",
                "Ing. Química",
                "Ing. En Semiconductores",
                "Ing. En Sistemas Computacionales"
        };

        String[] tipoUsuario = {
                "normal",
                "administrador",
        };

        String[] descripciones = {
                "Los aspirantes a ingresar al programa de Arquitectura preferentemente deberán mostrar una inclinación a las ciencias físico-matemáticas y humanidades, contar con capacidad analítica y deductiva, gran interés por el arte y la cultura, así como comprensión y visualización espacial, capacidad de síntesis y concretar pensamientos abstractos, interés por la ecología y la sustentabilidad, conocimientos elementales sobre representación gráfica, habilidad numérica y conocimientos de inglés.",
                "Las y los estudiantes al ingresar deberán tener habilidades para la comunicación oral y escrita, capacidad de reacción ante diferentes situaciones con actitud proactiva y responsable. Tener iniciativa, contar con la capacidad para establecer relaciones interpersonales, trabajo en equipo y apertura para conocer otras culturas al igual que desarrollar una segunda lengua.",
                "Las y los estudiantes al ingresar, deberán tener afinidad para vincular el valor de los recursos naturales y servicios ambientales y promover su uso sustentable de acuerdo a las necesidades de la región, mediante instrumentos de concientización, sensibilización y comunicación. Participar en el desarrollo y ejecución de protocolos de investigación básica o aplicada para la resolución de los problemas ambientales.",
                "Tener afinidad a las ciencias básicas como la biología, física, química y matemáticas, además de tener habilidad para la comunicación oral y escrita, así como la capacidad de reacción ante diferentes situaciones con actitud proactiva y responsable. Tener iniciativa y contar con la habilidad para establecer relaciones interpersonales y trabajo en equipo, estar dispuesto a incursionar en las ciencias biológicas como bioquímica, microbiología, bioquímica de los alimentos, microbiología industrial.",
                "Las y los estudiantes deberán ser creativos, responsables con habilidades para el análisis matemático, el manejo de las Tics y manifestar gusto y afición por la tecnología y las ciencias.",
                "Las y los estudiantes al ingresar, deberán tener habilidades para la comunicación oral y escrita, habilidades matemáticas, capacidades de reacción ante diferentes situaciones con actitud proactiva y responsable. Ing. Industrial Las y los estudiantes al ingresar deberán tener conocimientos de cultura general; así como habilidades matemáticas y de comunicación oral y escrita. Deberán contar con la capacidad de reacción ante diferentes situaciones con actitud proactiva y responsable.",
                "Afinidad para vincular conocimientos de cultura general. Habilidades y gusto por las matemáticas y la física. Capacidad de reacción ante diferentes situaciones con actitud proactiva y responsable. Tener iniciativa y contar con la capacidad para establecer relaciones interpersonales, trabajo en equipo.",
                "Las y los estudiantes al ingresar deberán tener habilidades matemáticas, conocimientos básicos de física, química y computación, habilidad para la comunicación oral y escrita, interés por el funcionamiento de máquinas, mecanismos y procesos industriales, inclinación personal por indagar y usar los avances tecnológicos, pensamiento analítico y sintético, capacidad de toma de decisiones, resolución de problemas y capacidad creativa.",
                "Al ingresar el estudiante deberá tener conocimientos básicos de física, química y matemáticas, así como la capacidad para analizar y aplicar la información específica, comunicar correctamente sus ideas en forma oral y escrita con pensamiento lógico matemático y capacidad para trabajar en equipo.",
                "Capacidad para integrar soluciones tecnológicas innovadoras. Disciplina en el cumplimiento de las normas de convivencia, el medio ambiente y la libertad. Habilidad de emprendimiento y gestión para incursionar en el sector de los negocios tecnológicos de semiconductores.",
                "El y la estudiante al ingresar, deberá tener habilidades matemáticas y lógicas, capacidad de análisis y síntesis de información, habilidades de investigación, así como interés por la computación y la programación, disposición para trabajar en equipo y sentido de compromiso social."
        };
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

        for (int i = 0; i < tipoUsuario.length; i++) {
            String insertPerfil = String.format(
                    "INSERT INTO catalogoUsuario (id_Catalogo_Usuario, tipoUsuario) VALUES (%d, '%s');",
                    i + 1, tipoUsuario[i]);
            writer.write(insertPerfil + "\n");
        }

        for (int i = 0; i < carrera.length; i++) {
            String insertPerfil = String.format(
                    "INSERT INTO perfil (id_perfiles, descripcion, carrera) VALUES (%d, '%s', '%s');",
                    i + 1, descripciones[i], carrera[i]);
            writer.write(insertPerfil + "\n");
        }

        for (int i = 0; i < preguntas.length; i++) {
            String insertCuestionario = String.format("INSERT INTO cuestionario (pregunta) VALUES ('%s');",
                    preguntas[i]);
            writer.write(insertCuestionario + "\n");
        }

        for (int i = 0; i < respuestas.length; i++) {
            String insertRespuesta = String.format("INSERT INTO respuesta (id_respuesta, respuesta) VALUES (%d, '%s');",
                    i + 1, respuestas[i]);
            writer.write(insertRespuesta + "\n");
        }

        for (int i = 0; i < cantidad; i++) {
            String insertUsuario = generarInsertAleatorio(cantidad);
            writer.write(insertUsuario + "\n");
        }

        for (int i = 0; i < cantidad; i++) {
            String insertRC = generarInsertAleatorioRC();
            writer.write(insertRC + "\n");
        }

        for (int i = 0; i < cantidad; i++) {
            String insertCP = generarInsertAleatorioCP();
            writer.write(insertCP + "\n");
        }

        for (int i = 0; i < cantidad; i++) {
            String insertCP = generarInsertAleatorioUC(cantidad);
            writer.write(insertCP + "\n");
        }

        for (int i = 0; i < cantidad; i++) {
            String insertCP = generarInsertAleatorioFeedback(cantidad);
            writer.write(insertCP + "\n");
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

    private static int contadorFeedback = 1;

    private static String generarInsertAleatorioFeedback(int cantidadUsuarios) {
        int idFeedback = contadorFeedback++; // Incrementa el contador de carreras
        Random random = new Random();

        String comentario = comentarios[random.nextInt(comentarios.length)];
        int calificacion = random.nextInt(5) + 1; // Calificación aleatoria entre 1 y 5

        return String.format("INSERT INTO feedback (id_feedback, comentario, calificacion) VALUES (%d, '%s', %d);",
                idFeedback, comentario, calificacion);
    }

    private static String generarInsertAleatorio(int cantidadUsuarios) {
        Random random = new Random();

        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido = apellidos[random.nextInt(apellidos.length)];
        String contrasena = contrasenas[random.nextInt(contrasenas.length)];
        String fechaNacimiento = fechasNacimiento[random.nextInt(fechasNacimiento.length)];
        String correo = correos[random.nextInt(correos.length)];
        int idCatalogoUsuario = idCatalogoUsuarios[random.nextInt(idCatalogoUsuarios.length)];
        long telefono = telefonos[random.nextInt(telefonos.length)];
        int idCatalogoPerfil = idCatalogoPerfiles[random.nextInt(idCatalogoPerfiles.length)];
        int idFeedback = random.nextInt(cantidadUsuarios);

        return String.format("INSERT INTO usuario (nombre, apellido, contrasena, fecha_nacimiento, correo, " +
                "id_catalogo_usuario, telefono, id_catalogo_perfil, id_feedback) VALUES ('%s', '%s', '%s', '%s', '%s', %d, %d, %d, %d);",
                nombre, apellido, contrasena, fechaNacimiento, correo, idCatalogoUsuario, telefono, idCatalogoPerfil,
                idFeedback);
    }

    private static String generarInsertAleatorioRC() {
        Random random = new Random();

        int idPregunta = random.nextInt(100) + 1; // Ajusta según tu número de preguntas
        int idRespuesta = random.nextInt(75) + 1; // Ajusta según tu número de respuestas

        return String.format("INSERT INTO respuesta_cuestionario (id_cuestionario, id_respuesta) VALUES (%d, %d);",
                idPregunta, idRespuesta);
    }

    private static int contadorCarrera = 1; // Variable para mantener el contador de carreras

    private static String generarInsertAleatorioCP() {
        int idCarrera = contadorCarrera++; // Incrementa el contador de carreras

        Random random = new Random();
        int tipoPerfilCarrera = random.nextInt(3) + 1; // Rango de tipo de perfil de 1 a 3
        int tipoPerfilPersona = random.nextInt(3) + 1; // Rango de tipo de perfil de 1 a 3

        return String.format(
                "INSERT INTO catalogo_perfiles (id_catalogo_perfil, tipo_perfil_carrera, tipo_perfil_persona) VALUES (%d, %d, %d);",
                idCarrera, tipoPerfilCarrera, tipoPerfilPersona);
    }

    private static String generarInsertAleatorioUC(int cantidadUsuarios) {
        Random random = new Random();

        int idPregunta = random.nextInt(100) + 1; // Ajusta según tu número de preguntas
        int idUsuario = random.nextInt(cantidadUsuarios) + 1; // Ajusta según la cantidad de usuarios creados

        return String.format("INSERT INTO usuario_cuestionario (id_cuestionario, id_usuario) VALUES (%d, %d);",
                idPregunta, idUsuario);
    }

}

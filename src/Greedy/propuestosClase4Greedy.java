package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingDeque;
import DivedAndConquer.mergeSort;
import DivedAndConquer.quickSort;

import Greedy.ObjetoMochila;

public class propuestosClase4Greedy {

    //	Imagine que se encuentra en Thurgau, donde dispone de las siguientes monedas: 5 francos, 2 francos, un franco, 50 centavos (medio franco), 20 centavos, 10 centavos, 5 centavos, y un centavo.
//	Usted debe pagar 8.78 francos por un paquete de frutillas (un producto típico local), y quiere usar la menor cantidad posible de monedas.
//
    //int monedas[] = {500, 200, 100, 50, 10, 1};
    // a pagar 875;
    public void frutillasThuragu(int monedas[], int aPagar) {

        int pagado = 0;
        int i = 0;

        while (pagado <= aPagar && i < monedas.length) {
            if (pagado + monedas[i] <= aPagar) {
                pagado += monedas[i];
                System.out.println("moneda de " + monedas[i]);
            } else
                i++;
        }
        if (pagado <= aPagar)
            System.out.println("no se puede pagar con su cambio");
    }


    public void mochilaFraccion(int valores[], int pesos[], int capaMochi) {
        //Primero busco la mejor relacion valor/peso
        ObjetoMochila[] mochiLA = new ObjetoMochila[4];
        Double robo[] = new Double[4];

        for (int i = 0; i < valores.length; i++) {
            mochiLA[i] = new ObjetoMochila(pesos[i], valores[i], (double) valores[i] / pesos[i]);
            robo[i] = (double) 0;
        }

        //Ordeno el array de mayor a menor
        /// TODO eso fue con chatGPT
        Arrays.sort(mochiLA, new Comparator<ObjetoMochila>() {
            @Override
            public int compare(ObjetoMochila o1, ObjetoMochila o2) {

                if (o1.getVxP() < o2.getVxP()) {
                    return 1; // Cambiamos el orden a 1
                } else if (o1.getVxP() > o2.getVxP()) {
                    return -1; // Cambiamos el orden a -1
                } else {
                    return 0;
                }
            }
        });

        Double pesoCargado = (double) 0;
        int i = 0;


        while (pesoCargado < capaMochi && i < robo.length) {
            //Si (capaMochi - pesoCargado)/mochiLA[i].getPeso()) es mayor a 1 significa que puedo poner el objeto entero
            robo[i] = (double) Math.min(1, (capaMochi - pesoCargado) / mochiLA[i].getPeso());
            pesoCargado = pesoCargado + mochiLA[i].getPeso() * robo[i];
            i++;
        }
        System.out.println(Arrays.toString(robo));
    }

    //concatena palabras utilizando la menor cantidad de simbolos
    public String combinarPalabras(String a, String b) {
        int maxOverlap = 0;
        String mejorCombinacion = a + b;//primero digo que esta es la mejor convinacion

        // Comprobar la superposición de a al final y b al principio
        for (int i = 1; i <= Math.min(a.length(), b.length()); i++) {
            if (a.substring(a.length() - i).equals(b.substring(0, i))) {
                if (i > maxOverlap) {
                    maxOverlap = i;
                    mejorCombinacion = a + b.substring(i);
                }
            }
        }
        // Comprobar la superposición de b al final y a al principio
        for (int i = 1; i <= Math.min(a.length(), b.length()); i++) {
            if (b.substring(b.length() - i).equals(a.substring(0, i))) {
                if (i > maxOverlap) {
                    maxOverlap = i;
                    mejorCombinacion = b + a.substring(i);
                }
            }
        }
        return mejorCombinacion;
    }

    //	Queremos seleccionar cinco números dentro de un arreglo con n números enteros positivos (n > 10) de manera que la suma de estos cinco números sea máxima. La restricción es que no se pueden elegir dos números vecinos. Se propone el siguiente algoritmo:
    public int sumMaxconRestriccion(int[] array) {
        int flag = 0;
        int suma = 0;
        while (flag < 5) {
            int mayor = 0;
            int indiceAMatar = 0;
            for (int i = 0; i < array.length; i++) {
                if (mayor < array[i]) {
                    mayor = array[i];
                    indiceAMatar = i;
                    if (i == 0)
                        array[i + 1] = 0;
                    else if (i == array.length - 1)
                        array[i - 1] = 0;
                    else {
                        array[i - 1] = 0;
                        array[i + 1] = 0;
                    }
                }
            }
            array[indiceAMatar] = 0;
            suma += mayor;
            flag++;
        }
        return suma;
    }

    /*    Tengo un unico recurso(piano) y N solicitudes para utilizarlo, estas indican la hora de inicio y la hora de fin. La solicitudes son
        para un dia determinado y queremos maximisar el numero de estudiantes que pueden usar el piano. Proponga un esque Greedy para
        resolver este problema*/
    public static class Solicitud implements Comparable<Solicitud> {
        private LocalTime horaInicio;
        private LocalTime horaFin;

        //Constructor Solicitud
        public Solicitud(LocalTime horaInicio, LocalTime horaFin) {
            this.horaInicio = horaInicio;
            this.horaFin = horaFin;
        }

        public LocalTime getHoraInicio() {
            return horaInicio;
        }

        public LocalTime getHoraFin() {
            return horaFin;
        }

        @Override
        public int compareTo(Solicitud otraSolicitud) {
            return this.horaFin.compareTo(otraSolicitud.horaFin);
        }
    }

    public int pianoFraileMuerto(Solicitud[] solicitudes) {
        //Voy a devolver el numero de solicitudes que pude meter
        PriorityQueue<Solicitud> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.addAll(Arrays.asList(solicitudes));//Esta linea es lo mismo que un for que recorra todo el array O(nlogn)
        Solicitud solicitudDesencolada1 = colaPrioridad.poll();//Poll es logaritmica
        int cantSolicitudesProcesadas = 1;//Aca ya cuento 1 por que ya saco la primera tarea que finaliza antes desde el vamos.
        while (!colaPrioridad.isEmpty()) {// O(n log n)
            Solicitud solicitudDesencolada2 = colaPrioridad.poll();
            if (solicitudDesencolada2.horaInicio.isBefore(solicitudDesencolada1.horaFin) || solicitudDesencolada2.horaInicio.equals(solicitudDesencolada1.horaInicio) && solicitudDesencolada2.horaFin.isAfter(solicitudDesencolada1.horaFin))
                System.out.println("La tarea con hora de inicio: " + solicitudDesencolada2.getHoraInicio() + "y hora fin: " + solicitudDesencolada1.getHoraFin() + "debe ser rechazada");
            else {
                cantSolicitudesProcesadas++;
                solicitudDesencolada1 = solicitudDesencolada2; //actualizo la solicitud
            }
            System.out.println("Hora inicio: " + solicitudDesencolada1.getHoraInicio() + " Hora fin: " + solicitudDesencolada1.getHoraFin());
        }
        return cantSolicitudesProcesadas;//complejidad del algoritmo O(n log n)
    }

    public int aulasFraileMuerto(Solicitud[] cursos) {
        //Voy a devolver el numero de solicitudes que pude meter
        PriorityQueue<Solicitud> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.addAll(Arrays.asList(cursos));//Esta linea es lo mismo que un for que recorra todo el array
        Solicitud solicitudDesencolada1 = colaPrioridad.poll();//Poll es logaritmica
        int cantDeAulas = 1;//Aca ya cuento 1 por que ya saco la primera tarea que finaliza antes desde el vamos.
        while (!colaPrioridad.isEmpty()) {
            Solicitud solicitudDesencolada2 = colaPrioridad.poll();
            if (!solicitudDesencolada2.horaInicio.isBefore(solicitudDesencolada1.horaFin) || !solicitudDesencolada2.horaInicio.equals(solicitudDesencolada1.horaInicio) && solicitudDesencolada2.horaFin.isAfter(solicitudDesencolada1.horaFin)){
                cantDeAulas++;
                solicitudDesencolada1 = solicitudDesencolada2; //actualizo la solicitud
            }
        }
        return cantDeAulas;
    }


    public void estudianteVago(int[] horasMaterias, int horasParaEstudiar ){
        int menorHoras = horasMaterias[0];

        while(horasParaEstudiar>0){
            int indice = 0;
            for(int i=1; i<horasMaterias.length;i++){//Busco la materias con menos horas.
                if(menorHoras>horasMaterias[i]){
                    menorHoras = horasMaterias[i];
                    indice = i;
                }
            }
            System.out.println("Materia a estudiar: " + indice+  " Cantidad de horas necesarias: " + horasMaterias[indice]);
            horasParaEstudiar = horasParaEstudiar - horasMaterias[indice];
            System.out.println("Horas para estudiar restantes: " + horasParaEstudiar);
            horasMaterias[indice]=9999;// pongo el valor en infinito
            menorHoras = horasMaterias[indice];
        }


    }

    public int cambioSignoEnArrglo(int[] A, int q) {
        PriorityQueue<Integer> cola = new PriorityQueue<>();
        int cambios = 0;
        for (int i = 0; i < A.length; i++) {
            cola.add(A[i]);
        }

        while (cambios != q) {
            int elemento = cola.remove();
            elemento = elemento * -1;
            cola.add(elemento);
            cambios++;

        }

        int suma = 0;

        for (int i = 0; i < A.length; i++) {
            suma = suma + cola.remove();
        }
        return suma;

    }

    public int buscarLadron (char[] S, int k){
        int capturas = 0;
        int posL = BuscarPosi(S,'l',0);
        int posP = BuscarPosi(S,'p',0);
        while(posP!=-1 && posL!=-1){
            if(Math.abs(posL-posP)<k){
                capturas++;
                posP = BuscarPosi(S,'p',posP+1);
                posL = BuscarPosi(S,'l',posL+1);
            } else if (posP<posL){//Busco otro policia
                posP = BuscarPosi(S,'p',posP+1);
            }
            else
                posL = BuscarPosi(S,'l',posL+1);
        }
        return capturas;
    }

    private int BuscarPosi(char[] S, char letra,int ultimaPosi ){
        int i = ultimaPosi;
        for(i = ultimaPosi;i<S.length;i++){
            if(S[i]==letra){
                return i;
            }
        }
        return -1;
    }

}//llave de cierre

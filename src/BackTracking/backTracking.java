package BackTracking;

import java.util.*;

public class backTracking {

    public boolean posicionDamas(int[] vec, int e) {
        boolean ok = false;
        // vec[e] es lo mismo que la columna, los indices del vector son las columnas
        vec[e] = 0;
        while (vec[e] < vec.length && !(ok)) {
            if (damaOK(vec, e)) {
                if (e == vec.length - 1)
                    ok = true;
                else
                    ok = posicionDamas(vec, e + 1);
            }
            vec[e] = vec[e] + 1;
        }
        return ok;
    }

    boolean damaOK(int vec[], int e) {
        for (int i = 0; i < e; i++) {
            // me fijo que la resta de las filas y las restas de las columnas no sea iguales
            // filas --> Math.abs(i-fila)
            // columnas --> Math.abs(vec[i]-vec[fila])
            if (vec[i] == vec[e] || (Math.abs(vec[i] - vec[e]) == Math.abs(i - e))) {
                return false;
            }
        }
        return true;
    }

    public void sumaSubConj(int[] v, int numBuscado, int etapa, int[] actSol, int actSum) {

        for (int i = 0; i <= 1; i++) {// El for va de 0 a 1 por que el numero puede estar o no, son solo 2 opciones.
            actSol[etapa] = i;// Aca voy poniendo si lo guardo o no osea (0 o 1)
            actSum = actSum + v[etapa] * i;// Si el numero no va se lo multilica por 0

            if (etapa == v.length - 1) {// me fijo si estoy al final del arbol
                if (actSum == numBuscado)
                    for (int j = 0; j < actSol.length; j++) {// Imprime lindo el resultado
                        System.out.print(actSol[j] + " ");
                    }
            } else {
                if (actSum <= numBuscado)
                    sumaSubConj(v, numBuscado, etapa + 1, actSol, actSum);
            }
        }
    }

    public void generacionNumBin(int[] v, int etapa) {
        for (int i = 0; i <= 1; i++) {
            v[etapa] = i;
            if (etapa == v.length - 1) {
                for (int j = 0; j < v.length; j++) {// Imprime lindo el resultado
                    System.out.print(v[j] + " ");
                }
                System.out.println();
            } else {
                generacionNumBin(v, etapa + 1);
            }
        }
    }

    public void generacionNumBinConRestriccion(int[] v, int etapa, int k) {
        for (int i = 0; i <= 1; i++) {
            v[etapa] = i;
            if (etapa == k - 1) {
                if (numOK(v, etapa)) {
                    for (int j = 0; j < k; j++) {// Imprime lindo el resultado
                        System.out.print(v[j] + " ");
                    }
                    System.out.println();
                }
                generacionNumBinConRestriccion(v, etapa + 1, k);
            } else if (etapa == k + 1) {//Esto es por que puedo tener como max K+2
                if (numOK(v, etapa)) {
                    for (int j = 0; j < v.length; j++) {// Imprime lindo el resultado
                        System.out.print(v[j] + " ");
                    }
                    System.out.println();
                }
            } else {
                generacionNumBinConRestriccion(v, etapa + 1, k);
            }
        }
    }

    private static boolean numOK(int[] v, int etapa) {
        boolean ok = true;
        int cantCeros = 0;
        int cantUnos = 0;
        for (int i = 0; i <= etapa; i++) {
            if (v[i] == 1)
                cantUnos++;
            else
                cantCeros++;
        }
        if (cantCeros == 0 || cantUnos == 0)
            ok = false;
        return ok;
    }

    //Suma total recibe la sumatoria total del array
    public void particionPartesIguales(int[] v, int sumTotal, int sumParcial, int etapa) {
        for (int i = 0; i <= 1; i++) {
            sumParcial = sumParcial + v[etapa] * i;
            sumTotal = sumTotal - v[etapa] * i;
            if (etapa == v.length - 1) {
                if (sumTotal == sumParcial)
                    System.out.print("partes iguels de " + sumParcial + "|" + sumTotal);
                System.out.println();
            } else if (sumParcial <= sumTotal)
                particionPartesIguales(v, sumTotal, sumParcial, etapa + 1);
        }
    }

    public void permutacionesSinRestriccion(char[] A, char[] S, int etapa) {
        for (int i = 0; i < A.length; i++) {
            S[etapa] = A[i];
            if (letraOk(S, etapa)) {
                if (etapa == A.length - 1) {
                    System.out.println(S);
                } else
                    permutacionesSinRestriccion(A, S, etapa + 1);
            }
        }
    }

    private static boolean letraOk(char[] S, int etapa) {
        boolean ok = true;
        for (int i = 0; i < etapa; i++) {
            if (S[i] == S[etapa])
                ok = false;
        }
        return ok;
    }

    public void permutacionesConRestriccion(char[] A, char[] S, int etapa) {
        for (int i = 0; i < A.length; i++) {
            S[etapa] = A[i];
            if (todoBien(S, etapa)) {
                if (etapa == A.length - 1) {
                    System.out.println(S);
                } else
                    permutacionesConRestriccion(A, S, etapa + 1);
            }
        }
    }

    private static boolean todoBien(char[] S, int etapa) {
        boolean ok = true;
        for (int i = 0; i < etapa; i++) {
            if (S[i] == S[etapa])
                ok = false;
            if (ok && etapa > 0) {//Etapa mayor a 0 es para no irnos fuera de indice
                if (Math.abs(S[etapa - 1] - S[etapa]) <= 1) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public void permutaciones(char[] chars, int etapa) {
        if (etapa == chars.length - 1) {//llegue al final, imprimo el resultado
            System.out.println(String.valueOf(chars));
        }

        for (int i = etapa; i < chars.length; i++)//no me puedo pasar del largo de la cadena
        {
            swap(chars, etapa, i);
            permutaciones(chars, etapa + 1);// indice +1 lo que hace es que el primer caracter quede fijo
            swap(chars, etapa, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public void particionPartesIguales2(int[] v, int[] solu, int etapa) {
        for (int i = 0; i <= 1; i++) {
            solu[etapa] = i;
            if (etapa == v.length - 1) {
                int s1 = 0;//lado izquierdo
                int s2 = 0;//lado derecho
                for (int j = 0; j <= v.length - 1; j++) {
                    if (solu[j] == 0)
                        s1 = s1 + v[j];
                    else
                        s2 = s2 + v[j];
                }
                if (s1 == s2) {
                    System.out.print("partes iguels de " + s1 + "|" + s2);
                    System.out.println();
                }
            } else
                particionPartesIguales2(v, solu, etapa + 1);
        }
    }///COMPLEJIDAD A=2 (tengo 2 llamados recursivos uno por true y otro por false)
    //			B=1 (lo que le saco a la entrada)
    //			K=1 (por el for interior que es lineal)

/// Considere 5 objetos con pesos (w1,w2,w3,..,w5) = (10,3,5,7,2) y una mochila de tamano m=15. Use una estrategia de backtracking para encontrar todas las combinanciones de objetos que bane exactamente en la mochila. Calcule la complejidad del metodo

    public void mochilaBackT(int[] v, int[] solu, int etapa, int mochila) {
        for (int i = 0; i <= 1; i++) {
            solu[etapa] = i;
            if (etapa == v.length - 1) {
                int carga = 0;//carga de la mochila
                for (int j = 0; j <= v.length - 1; j++) {
                    if (solu[j] == 1)
                        carga = carga + v[j];
                }
                if (carga == mochila) {

                    System.out.println();
                    for (int j = 0; j < v.length; j++) {// Imprime lindo el resultado
                        System.out.print(solu[j] + " ");
                    }
                }
            } else
                mochilaBackT(v, solu, etapa + 1, mochila);
        }
    }
    ///COMPLEJIDAD A=2 (tengo 2 llamados recursivos uno por true y otro por false)
    //			B=1 (lo que le saco a la entrada)
    //			K=1 (por el for interior que es lineal)
    //Exponenciasl  -- O(2^n)


///dadas cuatro variables booleanas  x0 x1 x2 x3 (o binarias) sujetas a las siguientes restricciones:
    //x1 =! x2 y el numero de variables en 1 debe ser impar

    public void variablesBooleanas(int[] solu, int etapa) {
        for (int i = 0; i <= 1; i++) {
            solu[etapa] = i;

            if (etapa == solu.length - 1) {
                if (restriccionOK(solu, etapa)) {
                    for (int j = 0; j < solu.length; j++) {// Imprime lindo el resultado
                        System.out.print(solu[j] + " ");
                    }
                    System.out.println();

                }
            } else
                variablesBooleanas(solu, etapa + 1);
        }
    }

    private boolean restriccionOK(int[] solu, int etapa) {
        int cantUnos = 0;
        for (int i = 0; i <= solu.length - 1; i++) {
            cantUnos = cantUnos + solu[i];
        }
        if (solu[1] == solu[2] || cantUnos % 2 != 0) {
            return false;
        }

        return true;
    }


    /*Se tiene un conjunto de salas numeradas del 0 hasta n. Las salas están comunicadas entre sí a través de puertas que se abren solamente
     en el sentido de la numeración creciente (si una puerta permite pasar de la sala i a la sala j, entonces i < j.)
    Todas las salas tienen un puerta saliente, excepto, por supuesto, la salas n.
    Construya un algoritmo que permita ir desde la sala 0 a la sala n atravesando la máxima cantidad de salas.*/
    public void salasCine(int currentRoom, int n, int[] doors, int roomsTraversed, int[] maxRooms) {
        // Actualizar el máximo de salas atravesadas
        maxRooms[0] = Math.max(maxRooms[0], roomsTraversed);

        // Caso base: Si estamos en la sala n, terminamos la recursión
        if (currentRoom == n) {
            return;
        }

        // Intentamos atravesar las salas siguientes
        for (int i = currentRoom + 1; i <= n; i++) {
            // Verificamos si hay una puerta desde la sala actual a la sala siguiente
            if (i - currentRoom <= doors[currentRoom]) {
                // Llamada recursiva para atravesar la siguiente sala
                salasCine(i, n, doors, roomsTraversed + 1, maxRooms);
            }
        }
    }

    //Ejercicio que me tomo en el final, me dan un numero n y en base a ese numero tengo que generar todas las combinaciones
    //O(!n)
    public void generadorDePermutaciones(int n, int etapa, int[] S, ArrayList<int[]> listaDeSubarreglos) {
        for (int i = 0; i < n; i++) {
            S[etapa] = i + 1;
            if (numOk(S, etapa)) {
                if (etapa == n - 1) {
                    int[] copiaArray = Arrays.copyOf(S, S.length);
                    listaDeSubarreglos.add(copiaArray);
                } else
                    generadorDePermutaciones(n, etapa + 1, S, listaDeSubarreglos);
            }
        }
    }

    private boolean numOk(int[] S, int etapa) {//Esto es para ver si el numero que quiero agregar esta OK
        boolean ok = true;
        for (int i = 0; i < etapa; i++) {// reviso toda mi solucion parcial en busca de repetidos
            if (S[i] == S[etapa])
                ok = false;
        }
        return ok;
    }

//	Implemente un algoritmo de backtracking para encontrar todas las permutaciones de los cuatro dígitos (1, 2, 3, 4)
//	de manera que ningún dígito quede repetido y que el valor absoluto de la diferencia entre un dígito cualqueira y su precedente sea a menor o igual a 2.

    public void numerosPrecedente(int A[], int etapa, int[] S) {
        for (int i = 0; i < A.length; i++) {
            S[etapa] = A[i];
            if (restricciones(S, etapa)) {
                if (etapa == A.length - 1) {
                    for (int j = 0; j < S.length; j++) {// Imprime lindo el resultado
                        System.out.print(S[j] + " ");
                    }
                    System.out.println();
                } else
                    numerosPrecedente(A, etapa + 1, S);
            }
        }
    }

    //Esto es para ver si el numero que quiero arreglar esta OK
    private boolean restricciones(int[] S, int etapa) {
        boolean ok = true;
        for (int i = 0; i < etapa; i++) {
            if (S[i] == S[etapa])
                ok = false;
            if (ok && etapa > 0) {//Etapa mayor a 0 es para no irnos fuera de indice
                if (Math.abs(S[etapa - 1] - S[etapa]) >= 2) {
                    ok = true;
                }
            }
        }
        return ok;
    }


    ///ALGORITMOS DE JUEGOS
//    Dos amigos resuelve jugar al siguiente juego con los once corchos de las botellas Château d’Yquem (Sauternes, cosecha 2000) que acaban de tomarse. Se juega por pares. Se colocan los once corchos sobre la mesa y cada jugador debe retirar uno, dos o tres corchos del grupo.
//    Ningún jugador puede “pasar”.
//    Pierde el jugador que retira el último corcho.
//    El juego se representa por un árbol (en nuestro caso un grafo) cuyos vértices están anotados con el número actual de corchos que quedan.

    public int corchos(int estado, int nivel) {//nivel es max o min, en estado tengo la cantidad de corchos
        int valor = 0;
        if (estado == 0) {//no hay mas corchos, entonces gana el jugador de turno
            return nivel; //es 1 o -1
        } else {
            int sig = 1;
            int val = -1 * nivel;// si nivel es Max, me queda 1*-1, si nivel es Min me queda -1*-1. Siempre considero el peor caso, si es Max es -1 y si es Min es +1
            boolean poda = false;
            while ((sig <= 3) && (sig < estado) && !poda) {//Sig<estado es para evitar sacar mas corchos de los que existen
                estado = estado - sig;// quito corcho del pilon
                if (nivel == 1)
                    val = Math.max(val, corchos(estado, -1 * nivel));
                else
                    val = Math.min(val, corchos(estado, -1 * nivel));

                if ((nivel * val) == 1)// n=1 y val 1 o n=-1 y val=-1 / Si me da 1 ya se que gano y no vale la pena seguir analizando
                    poda = true;
                else
                    estado = estado + sig;

                sig = sig + 1;
            }
            return val;
        }
    }

    public boolean hasCycle(int[][] graph) {
        int numVertices = graph.length;//Numero de vertices, es el largo de la matriz
        boolean[] visited = new boolean[numVertices];//Array de visitados para ir marcando los nodos visitados
        int[] camino = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {//Este for lo pone por que puedo tener un ciclo comenzando desde otros nodos,
            if (!visited[i]) {
                int result = nodoSinSalida(graph, visited, i, i, camino);
                if (result != 0) {
                    System.out.println(result);
                    return true;
                }
            }
        }

        return false;
    }

    private int nodoSinSalida(int[][] graph, boolean[] visited, int current, int parent, int[] camino) {
        visited[current] = true;//Marco el actual como visitado
        camino[current] = current + 1;
        int candidato = 0;
        int contador = 0;
        boolean tieneAristaSaliente = false;
        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[current][neighbor] == 1) {//Si tengo una arista me fijo si el nodo fue visitado
                tieneAristaSaliente = true;
                if (!visited[neighbor]) {
                    int resultado = nodoSinSalida(graph, visited, neighbor, current, camino);
                    if (resultado != 0)//Si encontro un nodo sin salida lo devuelve
                        return resultado;
                }
            }
        }
        if (!tieneAristaSaliente)
            return current;

        return 0;
    }

    public void permutacionesModel14(int[] v, int etapa, int n) {
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            v[etapa] = num;
            if ((i + num + 1) < v.length)
                v[i + num + 1] = num;

            if (restriccionModelo14(v, etapa, num, i)) {
                if (etapa == n - 1) {
                    for (int j = 0; j < v.length; j++) {//Imprime lindo
                        System.out.print(v[j] + " ");
                    }
                    System.out.println();
                } else
                    permutacionesModel14(v, etapa + 1, n);
            }

        }
    }

    private boolean restriccionModelo14(int[] v, int etapa, int num, int i) {
        int cantRepeticiones = 0;
        for (int j = 0; j < v.length; j++) {
            if (v[j] == num) {
                cantRepeticiones++;
            }
            if (cantRepeticiones > 2) {
                return false; // Excede la cantidad permitida de repeticiones
            }
        }

        return true;
    }

    // Complejidad: O(n!) en el peor caso
    public void buscarCombinaciones(int[] secuencia, boolean[] usado, int etapa, int n,
                                    List<int[]> soluciones) {
        if (etapa == secuencia.length) {
            soluciones.add(secuencia.clone());
            return;
        }

        if (secuencia[etapa] != 0) {
            // Si la posicion actual ya se ocupo, voy a la siguiente
            buscarCombinaciones(secuencia, usado, etapa + 1, n, soluciones);
        } else {
            // Intentamos colocar cada numero no usado en la pos actual.
            for (int i = 1; i <= n; i++) {
                int distanciaK = etapa + i + 1;//Esto es la separacion que tengo que tener entre los numeros
                if (!usado[i] && distanciaK < secuencia.length && secuencia[distanciaK] == 0) {
                    secuencia[etapa] = i;
                    secuencia[distanciaK] = i;
                    usado[i] = true;
                    buscarCombinaciones(secuencia, usado, etapa + 1, n, soluciones);
                    // Backtrack: Quitamos el numero de ambas posiciones y lo marcamos como no usado
                    secuencia[etapa] = 0;
                    secuencia[distanciaK] = 0;
                    usado[i] = false;
                }
            }
        }
    }

    //    Dado un arreglo A de n posiciones con números enteros (positivos o nega- tivos), se trata de dividir los n números en dos grupos de manera que la diferencia de las sumas de cada grupo sea mínima. Si el número n es par, los grupos deben tener estrictamente n/2 números cada uno. Si n es impar, uno de los grupos debe tener (n − 1)/2 elementos y el otro ((n − 1)/2) + 1.
    public void diferenciaMinimaEntreSubConjuntos(int[] A, int etapa, int[] grupo1,
                                                  int[] grupo2, int n, int mejorDif, int[] S) {
        if (etapa == A.length) {
            int suma1 = 0, suma2 = 0;
            for (int i = 0; i < grupo1.length; i++) {
                if (grupo1[i] == 1) {
                    suma1 += A[i];
                } else {
                    suma2 += A[i];
                }
            }
            int diferencia = Math.abs(suma1 - suma2);
            if (diferencia < mejorDif) {
                mejorDif = diferencia;
                System.arraycopy(grupo1, 0, S, 0, grupo1.length);
            }
            return;
        }
        grupo1[etapa] = 1; // Agregar A[idx] a grupo1
        diferenciaMinimaEntreSubConjuntos(A, etapa + 1, grupo1, grupo2, n, mejorDif, S);
        grupo1[etapa] = 0; // Quitar A[idx] de grupo1

        grupo2[etapa] = 1; // Agregar A[idx] a grupo2
        diferenciaMinimaEntreSubConjuntos(A, etapa + 1, grupo1, grupo2, n, mejorDif, S);
        grupo2[etapa] = 0; // Quitar A[idx] de grupo2
    }


    //    La excursión del caballo. Un caballo de ajedrez es una pieza que mueve dos
    //    casillas en una dirección y a continuación una casilla hacia un costado. Ver figura.
//    El problema que se desea resolver es el de recorrer un tablero de ajedrez de n × n posiciones
//    con un caballo visitando todas las casillas y sin repetir ninguna. Se pide:
    public boolean caballo(int[][] M, int x, int y, int[] movX, int[] movY, int n) {
        if (n == M.length * M.length)
            return true;

        for (int k = 0; k < movX.length; k++) {//Este for es para ir intentando todos los
            // movimientos posibles, en total el caballo puede hacer 8 movimiento
            int sigX = x + movX[k];//Estas dos posiciones son las siguientes en
            // las que voy a intentar mover el caballo
            int sigY = y + movY[k];

            if (caballoValido(sigX, sigY, M)) {
                M[sigX][sigY] = n;
                if (caballo(M, sigX, sigY, movX, movY, n + 1))
                    return true;
                else
                    M[sigX][sigY] = 0;
            }
        }
        return false;
    }//El árbol de recursión puede tener una profundidad máxima de n^2  ya que necesitamos
    // visitar todas las casillas del tablero. Por lo tanto, cada llamada recursiva puede generar
    // hasta 8 sub-llamadas recursivas, y esto se repite hasta que hayamos intentado llenar todas las n^2
    //casillas. La complejidad en términos de tiempo puede aproximarse a: 8^n^2

    private boolean caballoValido(int x, int y, int[][] M) {
        return x >= 0 && x < M.length && y >= 0 && y < M.length && M[x][y] == 0;
    }

    public boolean conjeo(int[][] M, int i, int j) {

        if (i == M.length - 1 && j == M.length - 1)
            return true;

        int k = 1;
        int saltos = M[i][j];
        while (k <= M[i][j]) {
            if (saltoValido(i + k, j, M)) {//Me fijo si me puedo mover para abajo
                if (conjeo(M, i + k, j))
                    return true;
            }
            if (saltoValido(i, j + k, M)) {//Me fijo si me puedo mover a la derecha
                if (conjeo(M, i, j + k))
                    return true;
            }
            k++;
        }
        return false;
    }

    private boolean saltoValido(int i, int j, int[][] M) {
        return i < M.length && j < M.length && M[i][j] != 0;
    }



//todos los caminos posibles en un grafo dirigido
    public void caminosGrafoDirigido(int [][] M, int origen, int [] visit,int etapa, String solucion){
        visit[origen]=1;
        solucion = solucion.concat(origen+"-->");
        if(etapa==M[0].length-1) {
            System.out.println(solucion);
            solucion = " ";
        }

        for(int j=0;j<M[0].length;j++){
            if(M[origen][j]==1 && verificarSolucion(visit,j) ) {//Hay arista de origen a J
                caminosGrafoDirigido(M,j,visit,etapa+1,solucion);
                visit[j]=0;
            }
        }
    }
//    Resumen:
//    La complejidad del algoritmo caminosGrafoDirigido es 𝑂(𝑛!), donde n es el número de nodos en el grafo.
//    Esta complejidad se debe a la naturaleza combinatoria de explorar todos los caminos posibles en un grafo dirigido.

    private boolean verificarSolucion(int[] S,int j){
        return S[j] == 0;
    }

    public void sumaSubConjunto(int etapa, int m, int[]v, int[]solu, int suma){
        if(etapa==v.length-1)
            return;

        for(int i=0; i<=1;i++){
            suma = suma + v[etapa]*i;//si i=0 deja sin efecto la suma de v[etapa]
            solu[etapa]=i;
            if(suma==m){//m es valor buscado
                System.out.println("La solucion esta compuesta por la suma de los siguientes numeros");
                for(int j=0;j<solu.length;j++)
                {if(solu[j]==1)
                    System.out.print(v[j]);
                }
                System.out.println();
            }
            //Llamo recursivamente si no llegue a la solucion
            sumaSubConjunto(etapa+1,m,v,solu,suma);
        }
    }

    //Recibis un numero n y tenes que haces todos los numeros binarios con n cantidad de bits

    public void numerosBinarios(int etapa, int []solu){
        for(int i=0;i<=1;i++){
            solu[etapa]=i;

            if(etapa==solu.length-1)
            {
                for(int j=0;j<solu.length;j++){
                    System.out.print(solu[j]);
                }
                System.out.println();
            }
            else
                numerosBinarios(etapa+1,solu);
        }
    }//A=2, B=1, K=0 --> O(2^n)

    //Me dan un subConjunto y tengo que generar todos los subconj posibles
    public void generacionSubConjuntos(int k, int etapa, Set<Integer> subconjunto){
        if (etapa > k) {
            System.out.println(subconjunto);
            return;
        }
        // No incluir el elemento en el subconjunto actual
        generacionSubConjuntos(k, etapa + 1, subconjunto);

        // Incluir el elemento en el subconjunto actual
        subconjunto.add(etapa);
        generacionSubConjuntos(k, etapa + 1, subconjunto);
        subconjunto.remove(etapa); // Backtrack
    }//El algoritmo realiza 2 llamadas recursivas en cada nivel, una agrega el elemento
     //y la otra no. Esto genera un arbol de recursion con K niveles.
     //En el peor de los casos la complejidad es O(2^k)


    public void permutacionesABCD(String[]v, int etapa, String[] solu ){
        for(int i=0;i<v.length;i++){
            solu[etapa]=v[i];
            if(nuevaLetraOk(solu,etapa)){
                if(etapa==v.length-1)
                    System.out.println(Arrays.toString(solu));
                else
                    permutacionesABCD(v,etapa+1,solu);
            }
        }
    }
    private boolean nuevaLetraOk(String[] solu, int etapa){
        for(int i =0;i<etapa;i++){
            if(solu[i].equals(solu[etapa]))
                return false;
        }
        return true;
    }
    //Dado que existen n! posibles permutaciones para n cantidad de letras, podemos decir que
    // la complejidad de este algoritmo
    //es O(n!)

    private static List<Integer>[] adjList;
    private static int maxSize = 0;
    private static Set<Integer> bestSet = new HashSet<>();
    //Subconjuntos independientes en un grafo no dirigido: dado un grafo no dirigido G = (V,E), un subconjunto
    // de nodos A ⊆ V es independiente o estable si no hay dos elementos en A que sean adyacentes.
    public void findMaxIndependentSet(int node, Set<Integer> currentSet, List<Integer>[] nodos) {
        if (node == nodos.length) {
            if (currentSet.size() > maxSize) {
                maxSize = currentSet.size();
                bestSet = new HashSet<>(currentSet);
                System.out.println("Max Independent Set Size: " + maxSize);
                System.out.println("Max Independent Set: " + bestSet);
            }
            return;
        }
        // Opción 1: No incluir el nodo actual en el conjunto independiente
        findMaxIndependentSet(node + 1, currentSet, nodos);
        // Opción 2: Incluir el nodo actual en el conjunto independiente si es válido
        if (isValid(node, currentSet,nodos)) {
            currentSet.add(node);
            findMaxIndependentSet(node + 1, currentSet, nodos);
            currentSet.remove(node); // Backtracking
        }
    }//Dado que hay un total de 2n combinaciones posibles (cada nodo puede estar o no estar en el conjunto),
    // la complejidad es exponencial. En términos de notación Big O, esto se expresa como O(2n).

    private  boolean isValid(int node, Set<Integer> currentSet,List<Integer>[] nodos) {
        for (int neighbor : nodos[node]) {
            if (currentSet.contains(neighbor)) {
                return false;
            }
        }
        return true;
    }

    //Encontrar estado de deadlock
    public boolean estadoDeadlock(int[][] M, int nodoactual, boolean[] visitados) {
        // Marcar el estado actual como visitado
        visitados[nodoactual] = true;
        // Comprobar si el estado actual es un estado de deadlock
        boolean isDeadlock = true;
        for (int j = 0; j < M.length; j++) {//Voy probando todas las aristas
            if (M[nodoactual][j] == 1) {
                isDeadlock = false;//con que tenga una arista ya no es deadlock
                break;
            }
        }
        if (isDeadlock) {//condicion de corte
            return true;
        }
        // Explorar todas las transiciones desde el estado actual
        for (int j = 0; j < M.length; j++) {
            if (M[nodoactual][j] == 1 && !visitados[j]) {//aca lo que hago es ver si tengouna
                // arista como para explortar
                //el nodo siguiente. La recursividad llama al otro nodo.
                if (estadoDeadlock(M, j, visitados)) {
                    return true;
                }
            }
        }
        // Desmarcar el estado actual para permitir otras rutas en la exploración
        visitados[nodoactual] = false;
        return false;
    }//O(n^2) en el peor de los casos, ya que para cada estado podemos visitar todos los otros estados,
    // y cada visita implica recorrer una fila de la matriz de adyacencia.

}// llave de cierre

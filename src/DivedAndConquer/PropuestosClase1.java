package DivedAndConquer;

public class PropuestosClase1 {

    //	La municipalidad de Fraile Muerto tiene un registro de los n productores de soja de la región (como todo el mundo sabe, Fraile Muerto está en el corazón de la región sojera de Córdoba.) Los referidos productores están registrados con números secuenciales (0, 1, 2, . . . , n − 1). Estos datos están almacenados en un vector P. Pero alguien se percata de que en el vector hay un elemento repetido, es decir que tiene n + 1 elementos en lugar de tener n, aunque el valor del último número es, correctamente,
//	n − 1. Se pide elaborar una estrategia y escribir el programa correspondiente para encontrar de manera eficiente la posición del elemento repetido detallando las diferentes partes que componen la solución y su relación con el esquema general.
//
    public int numeroRepetido(int[] vec, int ini, int fin) {
        //Caso base, vector de 1 elemento

        if (ini == fin)
            return ini;

        int mitad = (ini + fin) / 2;

        if (vec[mitad] == mitad) {//Hago esta comparacion con el indice por que dice que estan acomodados de acuerdo al indice. Ya si lo que tengo en el arreglo no esta en el indice es por que esta repetido.
            //el elemento repetido esta de la izq
            return numeroRepetido(vec, ini, mitad);
        }
        //el elemento repetido esta de la derecha
        else {
            return numeroRepetido(vec, mitad + 1, fin);
        }


    }


    public int arraysIguales(int[] array1, int[] array2, int ini, int fin) {
        if (ini == fin) {
            if (array1[ini] == array2[ini])
                return -1;
            else
                return 0;//No son iguales

        } else {
            int mitad = (ini + fin) / 2;
            int izq = arraysIguales(array1, array2, ini, mitad);
            int der = arraysIguales(array1, array2, mitad + 1, fin);

            return izq != -1 || der != -1 ? 0 : -1;
        }
    }


    public int raizEntera(int numRaiz, int ini, int fin) {

        if (numRaiz <= 1)
            return numRaiz;

        else if (fin == ini + 1) {
//Segundo caso base se redujo el especto de busqueda al mas chico posible. Aca el valor de ini es el valor maximo cuyo cuadrado es menor o igual a n.
            return ini;
        } else {
            int medio = (ini + fin) / 2;//Medio busca si el valor que elevado al cuadrado esta de la mitad inferior o de la mitad superior.
            if (medio * medio <= numRaiz) {
                ini = medio;
            } else {
                fin = medio;
            }
        }
        return raizEntera(numRaiz, ini, fin);

    }

//	El problema de la moneda falsa. El banco de Fraile Muerto recibió su primera remesa de monedas de cinco pesos. Dentro de un lote de n monedas se sabe que hay una falsa. La moneda falsa no se distingue de las otras sino por su peso: es un poco más pesada. Se dispone de una balanza de platillos que no da el peso cuantitativo; sólo dice si un grupo de monedas en un platillo pesa más, menos, o lo mismo que otro grupo de monedas en el otro platillo.
//	Disponiendo de este hardware, más bien modesto, determine el número mínimo de pesadas (en el peor caso) para identificar la moneda falsa.


    public int cantPesadas = 0;

    public int hayTrucha(int[] vec, int ini, int fin) {

        if (ini == fin) {//Caso base
            if (vec[ini] == 1)// Si la moneda es = a 1 la considero original
                return 0;
            else
                return 1;//Si devuelvo 1 si la moneda tiene un peso superior a 1
        } else {
            int mitad = (ini + fin) / 2;
            int montonIzquierdo = hayTrucha(vec, ini, mitad);
            int montonDerecho = hayTrucha(vec, mitad + 1, fin);

            if (montonIzquierdo == 0 && montonDerecho == 0)//No hay monedas falasas en los monticulos
                return 0;

            else if (montonIzquierdo < montonDerecho) {
                cantPesadas++;
                return cantPesadas;
            } else {
                cantPesadas++;
                return cantPesadas;
            }
        }
    }

    public int hayTrucha2(int[] vec, int ini, int fin) {
        int pasadaIzq = 0;
        int pasadaDer = 0;


        if (ini == fin && vec[ini] == 1)//Caso base, moneda original
            return 0;
        else if (ini == fin && vec[ini] != 1)
            return 1;//Si devuelvo 1 si la moneda tiene un peso superior a 1
        else {
            int mitad = (ini + fin) / 2;
            pasadaIzq++;
            int montonIzquierdo = hayTrucha(vec, ini, mitad);
            pasadaDer++;
            int montonDerecho = hayTrucha(vec, mitad + 1, fin);


            if (montonIzquierdo == 0 && montonDerecho == 0)//No hay monedas falasas en los monticulos
                return 0;
            else if (montonIzquierdo > montonDerecho) // Tengo la trucha en el monton izquierdo
                return pasadaIzq;
            else
                return pasadaDer;
        }
    } //Tipo division --> llamados recursivos(A)=2 cuanto se le quita a la entrada(B)=2 Grado del polinomio (K)=0 Complejidad: O(N) --> Lineal

/*Picos en un vector. Dado un vector u, un elemento pico es un elemento que no es menor que sus vecinos inmediatos. Encuentre un algoritmo eficiente (mejor que O(n)) que encuentre algún elemento pico en un vector de n posiciones. Observe que puede haber varios elementos pico; basta encontrar uno de ellos (siempre hay por lo menos uno.)
	Ejemplo. Si la entrada fuera [0, 1, 3, 2, 5, 1, 0] la respuesta podría ser 3 o 5. Si la entrada fuera [7, 2, 3, 4, 5, 6] la respuesta podría ser 7 o 6. Si la entrada fuera [1, 2, 3] la única respuesta sería 3.*/

    public int picosNOrec(int[] vec) {
        int pico = 0;
        for (int i = 0; i <= vec.length - 1; i++) {
            if (i > 0 && i < vec.length - 1) {
                if (vec[i - 1] < vec[i] && vec[i + 1] < vec[i]) {
                    pico = vec[i];
                    return pico;
                }
            } else if (i - 1 < 0 && vec[i + 1] < vec[i] || vec.length - 1 < i + 1 && vec[i] > vec[i - 1]) {
                pico = vec[i];
                return pico;
            }

        }
        return -1;
    }

    public int picosRecursivo(int[] vec, int ini, int fin) {
        int mitad = (ini + fin) / 2;

        if (ini == 0 && vec[ini] > vec[ini + 1]) {
            return vec[ini];
        } else if (vec[vec.length - 1] > vec[vec.length - 2]) {
            return vec[vec.length - 1];
        } else if (mitad != 0 && mitad != vec.length - 1 && vec[mitad - 1] < vec[mitad] && vec[mitad + 1] < vec[mitad]) {
            // Es pico y esta en el medio
            return vec[mitad];
        } else if (vec[mitad + 1] >= vec[mitad] && vec[mitad] >= vec[mitad - 1]) {
            //No es pico
            return picosRecursivo(vec, ini, mitad - 1);

        } else {
            return picosRecursivo(vec, ini, mitad + 1);//esto hace que la mitad me quede en el elemento mitad-1, es decir amplio los indices para incluir desde 0 hasta la mitad +1
        }
    }//Tipo division --> A=1 B=2 K=0 --> n^k log n -->O(n^log)

//	Suponga que v es un vector de n dígitos binarios ordenados. Encuentre un algoritmo eficiente (mejor que O(n)) que determine la cantidad de unos en v.
//	Ejemplo. Si v = [0, 0, 0, 1, 1, 1, 1, 1] (aquí n = 8). El programa debería retornar 5, que es la cantidad de unos en v.


    public int cantDeUnos(int[] vec, int ini, int fin) {

        if (ini == fin && vec[ini] == 1)
            return 1;
        else if (ini == fin && vec[ini] != 1)
            return 0;
        else {
            int mitad = (ini + fin) / 2;
            int izq = cantDeUnos(vec, ini, mitad);
            int der = cantDeUnos(vec, mitad + 1, fin);
            return izq + der;
        }
    }//Tipo division--> A=2 B=2 K=0 Caso a>b^k --> O(N) // no sirve


    public int cantDe1(int[] vec, int ini, int fin) {
        int mitad = (ini + fin) / 2;

        if (ini == fin && vec[ini] == 1)
            return 1;
        else if (ini == fin && vec[ini] != 1)
            return 0;
        else if (vec[mitad] == 0 && vec[mitad + 1] == 1)
            return vec.length - mitad - 1;
        else if (vec[mitad] == 1 && vec[mitad - 1] == 0)
            return vec.length - mitad;
        else if (vec[mitad] == 1)
            return cantDe1(vec, ini, mitad - 1);
        else
            return cantDe1(vec, mitad + 1, fin);
    }

    // Tengo un vector desordenado y quiero encontrar el séptimo elemento mayor en O(N)
// V = {2, 7, 4, 5, 3, 1, 8, 6, 10}
// V = {1, 2, 7, 4, 5, 3, 8, 6, 10}
// V = {1, 2, 3, 4, 5, 6, 7, 8, 10}
    public int septimoMayor(int[] vec, int ini, int fin) {
        int p = Pivot(vec, ini, fin);//Complejidad O(n)

        if (vec[vec.length - 7] == p)// tengo el septimo mayor justo en el pivot
            return p;
        else if (p > vec[vec.length - 7])//el septimo mayor esta del lado derecho
            return septimoMayor(vec, p, fin);
        else
            return septimoMayor(vec, p + 1, fin);
    }//Tipo sustraccion --> A=1 B=1 K=1 por lo tanto-->log n


    private int Pivot(int vec[], int ini, int fin) {

        int p = vec[ini];
        int i = ini + 1;
        int j = fin;

        while (i <= j) {
            //El elemento del array es menor al pivot
            while (i <= j && vec[i] < p) {
                i++;
            }
            //El elemento del array es mayor al pivot
            while (i <= j && vec[j] > p) {
                j--;
            }

            if (i <= j) {
                int aux = vec[i];
                vec[i] = vec[j];
                vec[j] = aux;
                i++;
                j--;
            }
        }
        int aux = vec[j];
        vec[j] = vec[ini];
        vec[ini] = aux;
        return j;
    }//El algoritmo de pivot ya me devuelve el arreglo ordenado en base al pivot que se tomo.


//PROBLEMA SUMA MAXIMA PARCIAL MPS

    public int sumMaxPar(int vec[], int ini, int fin) {

        if (ini == fin)//Caso base
            return vec[ini];

        else {
            int mitad = (ini + fin) / 2;
            int izq = sumMaxPar(vec, ini, mitad);
            int der = sumMaxPar(vec, mitad + 1, fin);
            int maxMitad = calcMaxMitad(vec, mitad);

            return Math.max(Math.max(izq, der), maxMitad);

        }
    }

    public int calcMaxMitad(int vec[], int mitad) {

        int izq, der, suma, sumParcial = 0;
        int LMPS = mitad;
        int RMPS = mitad + 1;
        //Max izq
        suma = vec[mitad];
        sumParcial = vec[mitad];
        for (int i = mitad - 1; i >= 0; i--) {
            sumParcial = sumParcial + vec[i];

            if ((suma + vec[i]) > suma && sumParcial > suma) {
                suma = suma + vec[i];
                LMPS--;
            }
        }
        izq = suma;
        suma = vec[mitad + 1];
        sumParcial = vec[mitad + 1];

        for (int j = mitad + 2; j <= vec.length - 1; j++) {
            sumParcial = sumParcial + vec[j];

            if ((suma + vec[j]) > suma && sumParcial > suma) {
                suma = suma + vec[j];
                RMPS++;
            }
        }
        der = suma;

        return izq + der;
    }

    public int ordenadoDesplazado(int vec[], int ini, int fin) {
        int mitad = (ini + fin) / 2;

        if (ini == fin) {        // caso base, es el mayor
            return vec[ini];
        } else if (vec[mitad] < vec[mitad - 1] && vec[mitad] < vec[mitad + 1])
            return vec[mitad - 1];
        else if (vec[mitad] > vec[mitad - 1] && vec[mitad] > vec[mitad + 1])
            return vec[mitad]; // Justo tengo el mayor en el medio
        else if (vec[mitad] > vec[mitad - 1] && vec[mitad] < vec[mitad + 1])
            return ordenadoDesplazado(vec, mitad + 1, vec.length - 1);//El mayor esta a la derecha
        else
            return -1;
    }

//Dado un arreglo ordenado con numeros todos diferentes A[0..n-1], usted quiere encontrar si existe un indice i tal que A[i]=i. De un algoritmo dive & conquer que resuelva este problema en tiempo O(log n)


    public int ordEnIndex(int vec[], int ini, int fin) {
        int mitad = (ini + fin) / 2;

        if (ini == fin)
            return vec[ini];

        else if (vec[mitad] == mitad)
            return vec[mitad];
        else if (vec[ini] == ini)
            return vec[ini];
        else if (vec[fin] == fin)
            return vec[fin];
        else if (mitad > vec[mitad] && ini > vec[ini]) // Los numeros que tengo en esta mitad nunca podrian entrar entre estos indices
            return ordEnIndex(vec, mitad + 1, fin);
        else
            return ordEnIndex(vec, ini, mitad);
    }


    public int searchInInfiniteArray(int vec[], int valBuscado) {
        int cotaIzq = 0;
        int cotaDer = 1;  // Inicialmente, asumimos un rango [0, 1]

        // Aumenta el rango exponencialmente hasta encontrar un límite superior
        while (vec[cotaDer] < valBuscado) {
            cotaIzq = cotaDer;
            cotaDer *= 2;
        }

        // Realiza una búsqueda binaria en el rango [left, right]
        while (cotaIzq <= cotaDer) {
            int mid = cotaIzq + (cotaDer - cotaIzq) / 2;

            if (vec[mid] == valBuscado) {
                return mid; // Encontrado
            } else if (vec[mid] < valBuscado) {
                cotaIzq = mid + 1;
            } else {
                cotaDer = mid - 1;
            }
        }

        return -1; // No encontrado
    }


    public int searchInInfiniteUnsortedArray(int[] A, int x, int left, int right) {
        if (left > right) {
            return -1; // No encontrado
        }

        int mid = left + (right - left) / 2;

        if (A[mid] == x) {
            return mid; // Encontrado
        }

        if (A[mid] == Integer.MAX_VALUE || A[mid] > x) {
            // Realizar búsqueda binaria a la izquierda
            return searchInInfiniteUnsortedArray(A, x, left, mid - 1);
        }

        // Realizar búsqueda binaria a la derecha
        return searchInInfiniteUnsortedArray(A, x, mid + 1, right);
    }

    public int busquedaModParcial(int vec[], int ini, int fin, int buscado) {

        int mitad = (ini + fin) / 2;

        if (ini == fin)
            return ini;

        if (vec[mitad] == buscado)
            return mitad;//El valor buscado esta justo en el medio

        else if (buscado > vec[mitad] && buscado > vec[mitad - 1])//me voy a la derecha
            return busquedaModParcial(vec, mitad + 1, vec.length, buscado);
        else
            return busquedaModParcial(vec, 0, mitad, buscado);

    }


    ///Tipo parcial -- Arreglo de numeros y una solucion que devuelva un par con el maximo y el minimo de todos los numeros

    public static class MinMaxPair {
        public int min;
        public int max;

        public MinMaxPair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }


    public MinMaxPair encontrarParMinMax(int[] vec, int ini, int fin) {
        if (ini == fin) {
            return new MinMaxPair(vec[ini], vec[ini]);
        }

        if (vec.length == 2) {
            return new MinMaxPair(Math.min(vec[ini], vec[fin]), Math.max(vec[ini], vec[fin]));
        }

        int mid = (ini + fin) / 2;

        MinMaxPair ramaIzq = encontrarParMinMax(vec, ini, mid);
        MinMaxPair ramaDer = encontrarParMinMax(vec, mid + 1, fin);

        int min = Math.min(ramaIzq.min, ramaDer.min);
        int max = Math.max(ramaIzq.max, ramaDer.max);

        return new MinMaxPair(min, max);
    }

    public int BusquedaExponencial(int[] vec, int t) {
        int k = 0;
        while (vec[(int) Math.pow(2, k)] <= t && (int) Math.pow(2, k) <= vec.length) {
            k++;
        }
        int izq = (int) Math.pow(2, k - 1);
        int der = (int) Math.pow(2, k);

        while (der > izq) {
            int mitad = (izq + der) / 2;
            if (vec[mitad] == t)
                return t;
            else if (t > vec[mitad]) {
                // El valor esta a la derecha
                izq = mitad + 1;
            } else {
                der = mitad - 1;
            }
        }
        return -1; // no se encontro el elemento
    }

    public int numeroCatalan(int n){
        if (n == 0) {
            return 1; // Caso base
        } else {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += numeroCatalan(i) * numeroCatalan(n - 1 - i);
            }
            return sum;
        }
    }


//    Techo de un número en un arreglo ordenado. Dado un arreglo de números enteros A y un número x, el techo de x en A es el menor valor A[i] tal que A[x] ≥ x.
//            Ejemplo: si tenemos A = [1,2,4,5,5,7,9,11], el techo de 6 en A es 7, el techo de 2 en A es 2 y el techo de −4 en A es 1
    public int techoDeUnNumero (int[]a, int x, int ini, int fin){

        if(ini==fin && a[ini]>=x)
            return a[ini];

        int mitad = (ini+fin)/2;
        if(a[mitad]==x)
            return a[mitad];
        else if(a[mitad]<x)//me voy a la derecha
            return techoDeUnNumero(a,x,mitad+1,a.length);
        else
            return techoDeUnNumero(a,x,ini,mitad);
    }

    public static int raizCuadradaEntera(int x) {
        if (x <= 1) return x; // Casos base para 0 y 1
        int inicio = 1, fin = x, resultado = 0;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (medio <= x / medio) {
                resultado = medio;
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return resultado;
    }



}//Llave de cierre general

public class CaminoMasCorto {
    public static void main(String[] args) {
        CaminoMasCorto lab = new CaminoMasCorto();

        int[][] laberinto = {{0,0,0,1,1}, 
                             {0,1,0,1,0},
                             {0,0,0,1,0},
                             {0,1,1,1,0},
                             {0,0,0,0,2}};

        //imprimiendo resultado
        for (int i = 0; i<laberinto.length; i++){
            for(int j = 0; j<laberinto.length; j++){
                System.out.print(laberinto[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("La cantidad minima de pasos para encontrar la salida es:" + lab.encontrarCamino(laberinto));
    }

    public int encontrarCamino (int[][] laberinto){
        
        return encontrarCamino(laberinto,0,0,0); //ultimo parametro que hasta ahora hemos dado 0 pasos
    }

    private int encontrarCamino(int [][] lab, int i, int j, int pasos){
        
        if(i>=0 && i<lab.length && j>=0 && j<lab[i].length) {  // si estoy dentro de la matriz
            if(lab[i][j] ==2){ //CASO BASE- si encontre la salida, devuelvo la cant de pasos
                return pasos;
            }
            else if (lab[i][j] ==1){ //CASO BASE- me encontre con una pared
                pasos= -1; 
            }
            else{
                lab[i][j]=1; //lo marco como visitado
                int c1, c2,c3,c4;
                c1= encontrarCamino(lab, i, j+1, pasos+1); // llamada recursiva para moverme a derecha
                c2= encontrarCamino(lab, i+1, j, pasos+1); // "" abajo
                c3= encontrarCamino(lab, i, j-1, pasos+1); // "" izquierda
                c4= encontrarCamino(lab, i-1, j, pasos+1); // "" arriba
                
                if(c1 != -1 && c2!= -1)      //comparo las 4 variables y me quedo con el camino mas corto.
                    pasos= Math.min(c1, c2);
                else
                    pasos= Math.max(c1, c2);
                
                if(c3 != -1 && pasos!= -1)
                    pasos = Math.min(c3, pasos);
                else
                    pasos= Math.max(c3, pasos);
                
                if(c4 != -1 && pasos!= -1)
                    pasos = Math.min(c4, pasos);
                else
                    pasos= Math.max(c4, pasos);
            
                lab[i][j]=0; // lo desmarco.
            }
        }
        else
            pasos=-1;
        
        return pasos;
    }
}

public class LightBoard {

private boolean[][] lights;

public LightBoard(int numRows, int numCols) {  
    lights = new boolean[numRows][numCols];
    for (int row = 0; row < lights.length; row++) {
        for (int col = 0; col < lights[0].length; col++) {
            if (Math.random() < 0.4) lights[row][col] = true;
        }
    }
}

public boolean evaluateLight(int row, int col) { 
    if (lights[row][col] == true) {
        int count = 0;
        for (int r = 0; r < lights.length; r++) {
            if (lights[r][col] == true) count++;
        }
        if (count % 2 == 0) return false;
        return true;
    }
    if (lights[row][col] == false) {
        int count = 0;
        for (int r = 0; r < lights.length; r++) {
            if (lights[r][col] == true) count++;
        }
        if (count % 3 == 0) return true;
    }
    return false;
}

public void setLights(boolean[][] arr) {
    lights = arr;
}

public double test() {
    double on = 0;
    for (boolean[] row : lights) {
        for (boolean b : row) {
            if (b) on++;

        }
    }
    return on / (lights.length * lights[0].length);
}

}
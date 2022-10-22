/**
 * ValidSudoku_36
 */
public class ValidSudoku_36 {

    public static void main(String[] args) {
        char[][] sudoku = { 
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }};
        
        ValidSudoku_36 resultSolutionValidSudoku = new ValidSudoku_36();
        System.out.println(resultSolutionValidSudoku.isValidSudoku(sudoku));
    }

    public boolean isValidSudoku(char[][] board) {
        char[] generateList = new char[9];

        for (int i = 0; i < board.length; i++) {
            // check row
            if (!checkList(board[i])) {
                return false;
            }
            // generate col
            for (int j = 0; j < board[i].length; j++) {
                generateList[j] = board[j][i];
            }
            // check col
            if (!checkList(generateList)) {
                return false;
            }
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int counter = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        generateList[counter] = board[(3*r)+ i][(3*c)+j];
                        counter += 1;
                    }
                }
                if (!checkList(generateList)) {
                    return false;
                }
            }
            
        }
        return true;
    }

    public boolean checkList(char[] row) {
        char[] valuesSeen = new char[9];
        char dot = '.';
        for (int i = 0; i < 9; i++) {
            if (row[i] != dot) {
                int val = Character.getNumericValue(row[i]);
                if (valuesSeen[val - 1] > 0) {
                    return false;
                } else {
                    valuesSeen[val - 1] += 1;
                }
            }
        }
        return true;
    }
}
import java.util.Scanner;


public class MineSweeper {
    int rowNumber;
    int colNumber;
    String[][] board;
    String[][] answerBoard;
    int mineNumber;
    int inputRow;
    int inputColumn;
    int minRowLimit;
    int maxRowLimit;
    int minColumnLimit;
    int maxColumnLimit;
    int correctAnswer = 0;
    int mineCount;


    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.board = new String[this.rowNumber][this.colNumber];
        this.answerBoard = new String[this.rowNumber][this.colNumber];
        this.mineNumber = rowNumber * colNumber / 4;

    }

    void fillArr() {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                this.board[i][j] = "-";
                this.answerBoard[i][j] = "-";
            }
        }
    }

    void printBoardAnswer() {
        System.out.println("Mayınların Yeri!!!!!");
        System.out.println("-------------------------------");
        placeMine();
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                System.out.print(this.answerBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");

    }

    void printBoard() {
        System.out.println("Dikkatt Mayına Basma :))");
        System.out.println("-------------------------------");

        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    void placeMine() {
        for (int i = 0; i < this.mineNumber; i++) {
            int mineRow = (int) (Math.random() * this.rowNumber);
            int mineColumn = (int) (Math.random() * this.colNumber);
            if (this.answerBoard[mineRow][mineColumn].equals("*")) {
                i--;
            }
            this.answerBoard[mineRow][mineColumn] = "*";
        }
    }

    void findMines() {
        this.minRowLimit = this.inputRow - 1;
        this.maxRowLimit = this.inputRow + 1;
        this.minColumnLimit = this.inputColumn - 1;
        this.maxColumnLimit = this.inputColumn + 1;

        if (this.minRowLimit < 0) {
            this.minRowLimit++;
        }
        if (this.maxRowLimit >= this.rowNumber) {
            this.maxRowLimit--;
        }
        if (this.minColumnLimit < 0) {
            this.minColumnLimit++;
        }
        if (this.maxColumnLimit >= this.colNumber) {
            this.maxColumnLimit--;
        }
        for (int i = this.minRowLimit; i <= this.maxRowLimit; i++) {
            for (int j = this.minColumnLimit; j <= this.maxColumnLimit; j++) {
                if (this.answerBoard[i][j].equals("*")) {
                    this.mineCount++;
                }
            }
        }
        this.board[this.inputRow][this.inputColumn] = Integer.toString(this.mineCount);
        this.mineCount = 0;
        this.answerBoard[this.inputRow][this.inputColumn] = "+";

    }

    void run() {
        Scanner scan = new Scanner(System.in);

        fillArr();
        this.printBoardAnswer();
        System.out.println();


        while (this.correctAnswer < this.rowNumber * this.colNumber - this.mineNumber) {
            this.printBoard();
            System.out.print("Enter Row: ");
            this.inputRow = scan.nextInt() - 1;
            System.out.print("Enter Column: ");
            this.inputColumn = scan.nextInt() - 1;

            if (this.inputRow < this.rowNumber && this.inputRow >= 0 && this.inputColumn < this.colNumber && this.inputColumn >= 0) {


                if (this.answerBoard[inputRow][inputColumn].equals("+")) {
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("Aynı Değerleri Girdiniz!!!!!");
                    System.out.println();

                } else {
                    correctAnswer++;

                }


                if (this.correctAnswer == this.rowNumber * this.colNumber - this.mineNumber) {
                    System.out.println("Tablonun Son Hali");
                    System.out.println("-------------------------------");
                    this.printBoard();
                    System.out.println("Tebrikler Kazandınız :)");
                    System.out.println("-------------------------------");
                }


                if (this.answerBoard[this.inputRow][this.inputColumn].equals("*")) {
                    System.out.println("Mayını Buldunuz ve Patladınız :(((");
                    System.out.println("-------------------------------");
                    break;
                }
                this.findMines();


            } else {
                System.out.println("Geçerli Bir Aralık Giriniz!!!");
                System.out.println("-------------------------------");
                this.correctAnswer--;
            }

        }
    }

}



import java.util.Scanner;

public class Calculator {
    
    // Method to print a number in 3D ASCII art
    public static void print3DNumber(double number) {
        String numStr = String.valueOf(number);
        String[][] lines = new String[7][numStr.length()];
        
        // Initialize all lines
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < numStr.length(); j++) {
                lines[i][j] = "";
            }
        }
        
        // Build ASCII art for each character
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            String[] digit = getDigitArt(c);
            for (int j = 0; j < 7; j++) {
                lines[j][i] = digit[j];
            }
        }
        
        // Calculate total width of the ASCII art
        int totalWidth = 0;
        for (int j = 0; j < numStr.length(); j++) {
            totalWidth += lines[0][j].length();
        }
        
        // Dynamic box width (content area) - minimum 38 or actual content width
        int contentWidth = Math.max(38, totalWidth);
        int boxWidth = contentWidth + 4; // Add padding on sides
        
        // Build dynamic borders
        StringBuilder topBorder = new StringBuilder("╔");
        StringBuilder bottomBorder = new StringBuilder("╚");
        StringBuilder middleBorder = new StringBuilder("╠");
        for (int i = 0; i < boxWidth; i++) {
            topBorder.append("═");
            bottomBorder.append("═");
            middleBorder.append("═");
        }
        topBorder.append("╗");
        bottomBorder.append("╝");
        middleBorder.append("╣");
        
        // Print the 3D number
        System.out.println();
        System.out.println(topBorder);
        
        // Print title centered
        String title = "YOUR RESULT IS:";
        int titlePadding = (boxWidth - title.length()) / 2;
        System.out.print("║");
        for (int i = 0; i < titlePadding; i++) System.out.print(" ");
        System.out.print(title);
        for (int i = 0; i < boxWidth - titlePadding - title.length(); i++) System.out.print(" ");
        System.out.println("║");
        
        System.out.println(middleBorder);
        
        for (int i = 0; i < 7; i++) {
            System.out.print("║  ");
            
            // Build the line content
            StringBuilder lineContent = new StringBuilder();
            for (int j = 0; j < numStr.length(); j++) {
                lineContent.append(lines[i][j]);
            }
            
            // Pad to dynamic width
            int padding = contentWidth - lineContent.length();
            System.out.print(lineContent);
            for (int p = 0; p < padding; p++) {
                System.out.print(" ");
            }
            
            System.out.println("  ║");
        }
        System.out.println(bottomBorder);
    }
    
    // Get 3D ASCII art for each digit/character
    public static String[] getDigitArt(char c) {
        switch (c) {
            case '0': return new String[] {
                "  ███████╗ ",
                " ██╔═══██╗",
                " ██║   ██║",
                " ██║   ██║",
                " ██║   ██║",
                " ╚██████╔╝",
                "  ╚═════╝ "
            };
            case '1': return new String[] {
                "  ██╗ ",
                " ███║ ",
                " ╚██║ ",
                "  ██║ ",
                "  ██║ ",
                "  ██║ ",
                "  ╚═╝ "
            };
            case '2': return new String[] {
                " ██████╗  ",
                "██╔═══██╗ ",
                "╚════██╔╝ ",
                "  ███╔═╝  ",
                " ███╔═╝   ",
                "███████╗  ",
                "╚══════╝  "
            };
            case '3': return new String[] {
                " ██████╗  ",
                "     ██║  ",
                "  █████║  ",
                "  █████║  ",
                "      ██║ ",
                " ██████╔╝ ",
                " ╚═════╝  "
            };
            case '4': return new String[] {
                " ██╗  ██╗ ",
                " ██║  ██║ ",
                " ███████║ ",
                " ╚════██║ ",
                "      ██║ ",
                "      ██║ ",
                "      ╚═╝ "
            };
            case '5': return new String[] {
                " ███████╗ ",
                " ██╔════╝ ",
                " ███████╗ ",
                " ╚════██║ ",
                "      ██║ ",
                " ███████║ ",
                " ╚══════╝ "
            };
            case '6': return new String[] {
                "  ██████╗ ",
                " ██╔════╝ ",
                " ███████╗ ",
                " ██╔═══██╗",
                " ██║   ██║",
                " ╚██████╔╝",
                "  ╚═════╝ "
            };
            case '7': return new String[] {
                " ███████╗ ",
                " ╚════██║ ",
                "     ██╔╝ ",
                "    ██╔╝  ",
                "   ██╔╝   ",
                "   ██║    ",
                "   ╚═╝    "
            };
            case '8': return new String[] {
                "  █████╗  ",
                " ██╔══██╗ ",
                " ╚█████╔╝ ",
                "  █████╗  ",
                " ██╔══██╗ ",
                " ╚█████╔╝ ",
                "  ╚════╝  "
            };
            case '9': return new String[] {
                "  █████╗  ",
                " ██╔══██╗ ",
                " ╚██████║ ",
                "  ╚═══██║ ",
                "      ██║ ",
                "  █████╔╝ ",
                "  ╚════╝  "
            };
            case '.': return new String[] {
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                " ██╗ ",
                " ╚═╝ "
            };
            case '-': return new String[] {
                "        ",
                "        ",
                "        ",
                " █████╗ ",
                " ╚════╝ ",
                "        ",
                "        "
            };
            default: return new String[] {
                "   ",
                "   ",
                "   ",
                "   ",
                "   ",
                "   ",
                "   "
            };
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display ASCII art
        System.out.println("   _____________________");
        System.out.println("  |  _________________  |");
        System.out.println("  | | 7 8 9 / C     | |");
        System.out.println("  | | 4 5 6 * DEL   | |");
        System.out.println("  | | 1 2 3 -       | |");
        System.out.println("  | | 0 . = +       | |");
        System.out.println("  | |_________________| |");
        System.out.println("  |₍ Calculate Magic ₎ |");
        System.out.println("  |_____________________|");
        System.out.println();
        System.out.println("=== Simple Number Calculator ===");
        System.out.println();
        
        try {
            // Get first number
            System.out.print("Enter the first number: ");
            double number1 = scanner.nextDouble();
            
            // Get second number
            System.out.print("Enter the second number: ");
            double number2 = scanner.nextDouble();
            
            // Calculate sum
            double sum = number1 + number2;
            
            // Display results
            System.out.println();
            System.out.println("=== Results ===");
            System.out.println("Number 1: " + number1);
            System.out.println("Number 2: " + number2);
            System.out.println();
            
            // Display sum in beautiful 3D ASCII art
            print3DNumber(sum);
            
        } catch (Exception e) {
            System.out.println("\nError: Please enter valid numbers!");
        } finally {
            scanner.close();
        }
    }
}

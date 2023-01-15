# Program Sederhana GUI Bangun Datar

Di sini saya akan mencoba menjelaskan bagaimana tahap pembuatan GUI sederhana untuk
menghitung bangun datar seperti Persegi, Persegi Panjang, dan Lingkaran. Jadi ada beberapa
metode terkait yang akan kita gunakan seperti,

            • Inheritance
            • Interface
            • Relasi Class
            • Event Driven
            
Jadi 4 metode di atas akan kita coba gunakan dalam penerapan pembuatan GUI Bangun
Datar sederhana saya, jadi langsung ke penjelasan yang pertama.


![image](https://user-images.githubusercontent.com/115923969/212537369-516b2ad0-f6ee-401a-ae46-2ef733a76b49.png)


1. Interface

Pertama sekali yang akan kita buat adalah sebuah interface, kenapa di sini kita
membuat interface? Karena kita ingin membuat sebuah gambaran/blue print sebelum
membuat hal-hal lain seperti rumus yang di gunakan.
Lalu apa saja yang kita isi di dalam interface? Disini saya membuat interface
bernama IBangunDatar dengan berisi 2 fungsi yaitu hitungLuas() dan hitungKeliling().
Jadi kita menyiapkan sebuah fungsi kosong yang nanti akan kita gunakan pada saat
membuat sebuah rumus bangun datar.


2. Parent Class

Selanjutnya kita akan membuat sebuah Class Parent dengan nama
RumusBangunDatar Di sini kita Implementasi terlebih dahulu dari Interface dengan
returnnya 0,


3. Child Class

Di sini kita bikin Child Class atau kelas turunan dari RumusBangunDatar, dan
disini kita akan melakukan perumusan pada setiap bangun datar agar fungsi yang di
jalankan sesuai dengan output bangun datarnya.






      - luasSegitiga.java


                import javax.swing.*;
                import java.awt.*;
                import java.awt.event.*;

                abstract class Shape {
                    abstract double getArea();
                }

                class Triangle extends Shape {
                    private double base;
                    private double height;

                    Triangle(double base, double height) {
                        this.base = base;
                        this.height = height;
                    }

                    double getArea() {
                        return 0.5 * base * height;
                    }
                }

                class GUI extends JFrame {
                    private JLabel baseLabel;
                    private JTextField baseField;
                    private JLabel heightLabel;
                    private JTextField heightField;
                    private JButton calculateButton;
                    private JLabel resultLabel;

                    GUI() {
                        setTitle("Triangle Area Calculator");
                        setSize(400, 150);
                        setLayout(new GridLayout(4, 2));
                        setDefaultCloseOperation(EXIT_ON_CLOSE);

                        baseLabel = new JLabel("Base:");
                        baseField = new JTextField();
                        heightLabel = new JLabel("Height:");
                        heightField = new JTextField();
                        calculateButton = new JButton("Calculate");
                        resultLabel = new JLabel();

                        calculateButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    double base = Double.parseDouble(baseField.getText());
                                    double height = Double.parseDouble(heightField.getText());
                                    Triangle triangle = new Triangle(base, height);
                                    double area = triangle.getArea();
                                    resultLabel.setText("Area: " + area);
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                                }
                            }
                        });

                        add(baseLabel);
                        add(baseField);
                        add(heightLabel);
                        add(heightField);
                        add(calculateButton);
                        add(resultLabel);

                        setVisible(true);
                    }
                }










4. Main Class

Terakhir kita akan membuat sebuah main class yang akan menjadi class yang
menjalankan program GUI kita, dan di sini saya menggambungkan design GUI dan
fungsi click nya di Main, agar mempermudah saya dalam membuatnya.





















        - main.java


                public class Main {
                    public static void main(String[] args) {

                        GUI gui = new GUI();
                        gui.setVisible(true);
                    }
                }








![image](https://user-images.githubusercontent.com/115923969/212537659-61a0e7be-cd01-45e3-b0cb-e1918ccef092.png)


Baik mungkin itu saja projek sederhana dari saya, kurang lebihnya mohon maaf terima
kasih kepada semua terutama bapak dosen yang telah membagikan ilmunya mengenai
Pemrograman Berorientasi Objek, sekian Wassalamualaikum wr.wb

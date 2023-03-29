import javax.swing.JFrame;

public class ArtVisual extends JFrame {
    
    public ArtVisual() {
        setTitle("Art Visual");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new DrawPanel());
    }

    public static void main(String[] args) {
        ArtVisual av = new ArtVisual();
        av.setVisible(true);
    }
}

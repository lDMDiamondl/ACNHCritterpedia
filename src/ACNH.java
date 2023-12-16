import javax.swing.*;
import java.awt.*;

public class ACNH
{
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel[] panels;
    private JButton[] buttons;

    public ACNH ()
    {
        cardLayout = new CardLayout ();
        cardPanel = new JPanel (cardLayout);

        panels = new JPanel[4];
        panels[0] = new Panel1 (); panels[1] = new Panel2 ();
        panels[2] = new Panel3 (); panels[3] = new Panel4 ();

        buttons = new JButton[4];
        buttons[0] = createButton ("물고기", "Panel1");
        buttons[1] = createButton ("곤충", "Panel2");
        buttons[2] = createButton ("화석", "Panel3");
        buttons[3] = createButton ("미술품", "Panel4");

        for (int i = 0; i < 4; i++)
        {
            cardPanel.add (panels[i], "Panel" + (i + 1));
            addCardNbutton (buttons[i], "Panel" + (i + 1));
        }

        JPanel controlPanel = new JPanel ();
        controlPanel.setBackground (new Color (199, 251, 255));

        for (var x : buttons)
            controlPanel.add (x);

        frame = new JFrame ("모여봐요 동물의 숲 생물도감");
        frame.setIconImage (Toolkit.getDefaultToolkit ().getImage ("src/images/icon.png")); // JFrame 아이콘 변경
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize (1280, 720);
        frame.setResizable (false);  // 창 크기 조절 X
        frame.setLocationRelativeTo (null);  // 창이 중앙으로 오게 하는 코드
        frame.getContentPane ().add (cardPanel, BorderLayout.CENTER);
        frame.getContentPane ().add (controlPanel, BorderLayout.SOUTH);
        frame.setVisible (true);
    }

    /* 버튼 생성 함수 */
    private JButton createButton (String text, String panel)
    {
        JButton button = new JButton (text);
        button.setBackground (Color.WHITE);
        return button;
    }

    /* CardLayout을 통해 화면 전환을 할 버튼을 생성하는 함수 */
    private void addCardNbutton (JButton button, String panel)
    {
        button.addActionListener (e -> cardLayout.show (cardPanel, panel));
    }

    public static void main (String[] args)
    {
        new ACNH ();
    }
}

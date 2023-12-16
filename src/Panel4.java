import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class Panel4 extends JPanel
{
    public Panel4 ()
    {
        setBackground (new Color (197, 237, 213));
        setLayout (null);

        /* 미술품의 이름을 기록, 판매 가격은 모두 1245벨로 동일하므로 기록 X */
        var name = new String[] {"가라앉는 명화", "가치 있는 명화", "거룩한 조각", "근사한 명화",
                                "느낌이 좋은 명화", "늠름한 조각", "단서가 되는 조각", "대단한 명화",
                                "돌 머리의 조각", "듬직한 조각", "뛰어난 명화", "멋들어진 명화",
                                "모성이 느껴지는 조각", "무사의 조각", "미스터리한 명화", "반짝이는 명화",
                                "빛의 명화", "섬세한 명화", "신비로운 조각", "씩씩한 명화",
                                "아늑한 명화", "아름다운 조각", "아카데믹한 명화", "어마어마한 조각",
                                "엄숙한 명화", "예쁜 명화", "용감한 명화", "위대한 조각",
                                "유명한 명화", "익숙한 조각", "재미있는 명화", "절제된 명화",
                                "좋은 명화", "진귀한 명화", "침착한 명화", "태고의 조각",
                                "평범한 명화", "평온한 명화", "혼란스러운 명화의 오른쪽", "혼란스러운 명화의 왼쪽",
                                "활기 넘치는 명화", "훌륭한 명화", "힘찬 명화"};
        var buttons = new JButton[43];

        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new JButton (new ImageIcon ("src/images/art/art" + i + ".png"));
            buttons[i].setBackground (Color.WHITE);

            int x = i % 10 * 80 + 230;
            int y = i / 10 * 80;
            int buttonIndex = i;

            buttons[i].setBounds (x, y, 80, 80);
            add (buttons[i]);
            buttons[i].addActionListener (e -> notifyButtonPressed ("이름: " + name[buttonIndex] + "\n가격: 1245", buttonIndex));
        }
    }

    private void notifyButtonPressed (String message, int buttonIndex)
    {
        JPanel panel = new JPanel (new FlowLayout ());
        JLabel artIcon = new JLabel (new ImageIcon ("src/images/art/art" + buttonIndex + ".png"));
        JTextArea textArea = new JTextArea (message);
        textArea.setEditable (false);  // textArea 수정 불가

        /* textarea와 artIcon에 검은색 테두리 추가 */
        Border border = BorderFactory.createLineBorder (Color.BLACK);
        textArea.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (10, 10, 10, 10)));
        artIcon.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (0, 0, 0, 0)));

        panel.add (artIcon); panel.add (textArea);
        JOptionPane.showMessageDialog (this, panel, "미술품 정보", JOptionPane.PLAIN_MESSAGE);
    }
}
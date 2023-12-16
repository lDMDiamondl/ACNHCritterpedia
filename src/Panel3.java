import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class Panel3 extends JPanel
{
    public Panel3 ()
    {
        setBackground (new Color (197, 237, 213));
        setLayout (null);

        /* 화석의 이름, 판매 가격을 기록. */
        var name = new String[] {"대변 화석", "데이노니쿠스의 꼬리", "데이노니쿠스의 머리", "둔클레오스테우스",
                                "디메트로돈의 머리", "디메트로돈의 몸통", "디플로도쿠스의 가슴", "디플로도쿠스의 꼬리",
                                "디플로도쿠스의 꼬리 끝", "디플로도쿠스의 머리", "디플로도쿠스의 목", "디플로도쿠스의 허리",
                                "매머드의 머리", "매머드의 몸통", "메가케롭스의 꼬리", "메가케롭스의 머리",
                                "메가케롭스의 몸통", "메갈로케로스의 오른쪽 반신", "메갈로케로스의 왼쪽 반신", "밀로쿤밍기아",
                                "발자국 화석", "브라키오사우루스의 가슴", "브라키오사우루스의 꼬리", "브라키오사우루스의 머리",
                                "브라키오사우루스의 허리", "삼엽충", "상어 이빨 화석", "스밀로돈의 머리",
                                "스밀로돈의 몸통", "스테고사우루스의 꼬리", "스테고사우루스의 머리", "스테고사우루스의 몸통",
                                "스피노사우루스의 꼬리", "스피노사우루스의 머리", "스피노사우루스의 몸통", "시조새",
                                "아노말로카리스", "아르켈론의 머리", "아르켈론의 몸통", "아칸토스테가",
                                "안킬로사우루스의 꼬리", "안킬로사우루스의 머리", "안킬로사우루스의 몸통", "암모나이트",
                                "에우스테놉테론", "오스트랄로피테쿠스", "오프탈모사우루스의 머리", "오프탈모사우루스의 몸통",
                                "이구아노돈의 꼬리", "이구아노돈의 머리", "이구아노돈의 몸통", "쥐라마이아",
                                "케찰코아틀루스의 머리", "케찰코아틀루스의 오른날개", "케찰코아틀루스의 왼날개", "트리케라톱스의 꼬리",
                                "트리케라톱스의 머리", "트리케라톱스의 몸통", "티렉스의 꼬리", "티렉스의 머리",
                                "티렉스의 몸통", "파라사우롤로푸스의 꼬리", "파라사우롤로푸스의 머리", "파라사우롤로푸스의 몸통",
                                "파키케팔로사우루스의 머리", "파키케팔로사우루스의 몸통", "프테라노돈의 머리", "프테라노돈의 오른날개",
                                "프테라노돈의 왼날개", "호박", "후타바사우루스의 꼬리", "후타바사우루스의 머리", "후타바사우루스의 몸통"};
        var price = new int[] {1100, 2500, 3000, 3500, 5500, 5000, 4000, 5000, 4000, 5000,
                                4500, 4500, 3000, 2500, 3000, 4500, 3500, 5500, 4000, 1500,
                                1000, 5500, 5500, 6000, 5000, 1300, 1000, 2500, 2000, 4000,
                                5000, 4500, 2500, 4000, 3000, 1300, 2000, 4000, 3500, 2000,
                                2500, 3500, 3000, 1100, 2000, 1100, 2500, 2000, 3000, 4000,
                                3500, 1500, 4500, 5000, 5000, 4500, 5500, 5000, 5000, 6000,
                                5500, 2500, 3500, 3000, 4000, 3500, 4000, 4500, 4500, 1200,
                                4500, 4000, 4500};
        var buttons = new JButton[73];

        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new JButton (new ImageIcon ("src/images/fossil/fossil" + i + ".png"));
            buttons[i].setBackground (Color.WHITE);

            int x = i % 10 * 80 + 230;
            int y = i / 10 * 80;
            int buttonIndex = i;

            buttons[i].setBounds (x, y, 80, 80);
            add (buttons[i]);
            buttons[i].addActionListener (e -> notifyButtonPressed ("이름: " + name[buttonIndex] + "\n가격: " + price[buttonIndex], buttonIndex));
        }
    }

    private void notifyButtonPressed (String message, int buttonIndex)
    {
        JPanel panel = new JPanel (new FlowLayout ());
        JLabel fossilIcon = new JLabel (new ImageIcon ("src/images/fossil/fossil" + buttonIndex + ".png"));
        JTextArea textArea = new JTextArea (message);
        textArea.setEditable (false);  // textArea 수정 불가

        /* textarea와 fossilIcon에 검은색 테두리 추가 */
        Border border = BorderFactory.createLineBorder (Color.BLACK);
        textArea.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (10, 10, 10, 10)));
        fossilIcon.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (0, 0, 0, 0)));

        panel.add (fossilIcon); panel.add (textArea);
        JOptionPane.showMessageDialog (this, panel, "화석 정보", JOptionPane.PLAIN_MESSAGE);
    }
}
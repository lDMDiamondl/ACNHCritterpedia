import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class Panel1 extends JPanel
{   
    private JButton[] buttons, monthButtons;
    private int[] price;
    private String[] name, place, month, time, size, rarity;
    private boolean[][] canCatch;

    public Panel1 ()
    {
        setBackground (new Color (197, 237, 213));
        setLayout (null);
        
        /* 물고기 데이터, 별도의 csv나 json 파일로 분리하려고 하였으나 시간 부족 및 유지보수가 필요없는 프로그램이기에 방치합니다.
         * 물고기의 이름, 판매 가격, 포획 장소, 포획 시기, 포획 가능 여부, 포획 시간, 물고기 크기, 물고기 희귀도를 기록. */
        name = new String[] {"납줄개", "피라미", "붕어", "황어", "잉어",
                            "비단잉어", "금붕어", "툭눈금붕어", "난주", "송사리",
                            "가재", "자라", "늑대거북", "올챙이", "개구리",
                            "동사리", "미꾸라지", "메기", "가물치", "블루길",
                            "옐로우퍼치", "큰입배스", "틸라피아", "강꼬치고기", "빙어",
                            "은어", "산천어", "열목어", "금송어", "일본연어",
                            "연어", "왕연어", "참게", "구피", "닥터피시",
                            "천사어", "베타", "네온테트라", "레인보우피시", "피라니아",
                            "아로와나", "도라도", "가아", "피라루쿠", "엔드리케리",
                            "철갑상어", "클리오네", "해마", "흰동가리", "블루탱",
                            "나비고기", "나폴레옹피시", "쏠베감펭", "복어", "가시복",
                            "멸치", "전갱이", "돌돔", "농어", "도미",
                            "가자미", "넙치", "오징어", "곰치", "리본장어",
                            "다랑어", "청새치", "무명갈전갱이", "만새기", "개복치",
                            "가오리", "톱상어", "귀상어", "상어", "고래상어",
                            "빨판상어", "초롱아귀", "산갈치", "데메니기스", "실러캔스"};
        price = new int[] {900, 200, 160, 240, 300, 4000, 1300, 1300, 4500, 300,
                            200, 3750, 5000, 100, 120, 400, 400, 800, 5500, 180,
                            300, 400, 800, 1800, 400, 900, 1000, 3800, 15000, 15000,
                            700, 1800, 2000, 1300, 1500, 3000, 2500, 500, 800, 2500,
                            10000, 15000, 6000, 10000, 4000, 10000, 1000, 1100, 650, 1000,
                            1000, 10000, 500, 5000, 250, 200, 150, 5000, 400, 3000,
                            300, 800, 500, 2000, 600, 7000, 10000, 4500, 6000, 4000,
                            3000, 12000, 8000, 15000, 13000, 1500, 2500, 9000, 15000, 15000};
        place = new String[] {"강", "강", "강", "강", "연못",
                            "연못", "연못", "연못", "연못", "연못",
                            "연못", "강", "강", "연못", "연못",
                            "강", "강", "연못", "연못", "강",
                            "강", "강", "강", "강", "강",
                            "강", "강 (연못 위)", "강 (연못 위)", "강 (연못 위)", "강 (연못 위)",
                            "강 (하구)", "강 (하구)", "강", "강", "강",
                            "강", "강", "강", "강", "강",
                            "강", "강", "연못", "강", "강",
                            "강 (하구)", "바다", "바다", "바다", "바다",
                            "바다", "바다", "바다", "바다", "바다",
                            "바다", "바다", "바다", "바다", "바다",
                            "바다", "바다", "바다", "바다", "바다",
                            "부두", "부두", "부두", "부두", "바다",
                            "바다", "바다", "바다", "바다", "바다",
                            "바다", "바다", "바다", "바다", "바다 (비)"};
        month = new String[] {"11 ~ 3", "365일", "365일", "365일", "365일",
                            "11 ~ 3", "365일", "365일", "365일", "4 ~ 8",
                            "4 ~ 9", "8 ~ 9", "4 ~ 10", "3 ~ 7", "5 ~ 8",
                            "365일", "3 ~ 5", "5 ~ 10", "6 ~ 8", "365일",
                            "10 ~ 3", "365일", "6 ~ 10", "9 ~ 12", "12 ~ 2",
                            "7 ~ 9", "3 ~ 6, 9 ~ 11", "3 ~ 6, 9 ~ 11", "3 ~ 5, 9 ~ 11", "12 ~ 3",
                            "9", "9", "9 ~ 11", "4 ~ 11", "5 ~ 9",
                            "5 ~ 10", "5 ~ 10", "4 ~ 11", "5 ~ 10", "6 ~ 9",
                            "6 ~ 9", "6 ~ 9", "6 ~ 9", "6 ~ 9", "6 ~ 9",
                            "9 ~ 3", "12 ~ 3", "4 ~ 11", "4 ~ 9", "4 ~ 9",
                            "4 ~ 9", "7 ~ 8", "4 ~ 11", "11 ~ 2", "7 ~ 9",
                            "365일", "365일", "3 ~ 11", "365일", "365일",
                            "10 ~ 4", "365일", "12 ~ 8", "8 ~ 10", "6 ~ 10",
                            "11 ~ 4", "11 ~ 4, 7 ~ 9", "5 ~ 10", "5 ~ 10", "7 ~ 9",
                            "8 ~ 11", "6 ~ 9", "6 ~ 9", "6 ~ 9", "6 ~ 9",
                            "6 ~ 9", "11 ~ 3", "12 ~ 5", "365일", "365일"};
        canCatch = new boolean[][] {{true, true, true, false, false, false, false, false, false, false, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, false, false, false, false, false, false, false, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, true, true, true, true, true, false, false, false, false},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, false, false, false, false, false, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, true, false, false},
                            {false, false, true, true, true, true, true, false, false, false, false, false},
                            {false, false, false, false, true, true, true, true, false, false, false, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, true, true, true, false, false, false, false, false, false, false},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {false, false, false, false, false, true, true, true, false, false, false, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, false, false, false, false, false, false, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, false, false, true, true, true, true, true, false, false},
                            {false, false, false, false, false, false, false, false, true, true, true, true},
                            {true, true, false, false, false, false, false, false, false, false, false, true},
                            {false, false, false, false, false, false, true, true, true, false, false, false},
                            {false, false, true, true, true, true, false, false, true, true, true, false},
                            {false, false, true, true, true, true, false, false, true, true, true, false},
                            {false, false, true, true, true, false, false, false, true, true, true, false},
                            {true, true, true, false, false, false, false, false, false, false, false, true},
                            {false, false, false, false, false, false, false, false, true, false, false, false},
                            {false, false, false, false, false, false, false, false, true, false, false, false},
                            {false, false, false, false, false, false, false, false, true, true, true, false},
                            {false, false, false, true, true, true, true, true, true, true, true, false},
                            {false, false, false, false, true, true, true, true, true, false, false, false},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {false, false, false, true, true, true, true, true, true, true, true, false},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {true, true, true, false, false, false, false, false, true, true, true, true},
                            {true, true, true, false, false, false, false, false, false, false, false, true},
                            {false, false, false, true, true, true, true, true, true, true, true, false},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, true, true, true, true, true, true, true, true, false},
                            {true, true, false, false, false, false, false, false, false, false, true, true},
                            {false, false, false, false, false, false, true, true, true, false, false, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, true, true, true, true, true, true, true, true, true, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, false, false, false, false, false, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, false, false, false, true},
                            {false, false, false, false, false, false, false, true, true, true, false, false},
                            {false, false, false, false, false, true, true, true, true, true, false, false},
                            {true, true, true, true, false, false, false, false, false, false, true, true},
                            {true, true, true, true, false, false, true, true, true, false, true, true},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {false, false, false, false, false, false, true, true, true, false, false, false},
                            {false, false, false, false, false, false, false, true, true, true, true, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {true, true, true, false, false, false, false, false, false, false, true, true},
                            {true, true, true, true, true, false, false, false, false, false, false, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true}};
        time = new String[] {"하루종일", "9AM ~ 4PM", "하루종일", "4PM ~ 9AM", "하루종일",
                            "4PM ~ 9AM", "하루종일", "9AM ~ 4PM", "9AM ~ 4PM", "하루종일",
                            "하루종일", "4PM ~ 9AM", "9PM ~ 4AM", "하루종일", "하루종일",
                            "4PM ~ 9AM", "하루종일", "4PM ~ 9AM", "9AM ~ 4PM", "9AM ~ 4PM",
                            "하루종일", "하루종일", "하루종일", "하루종일", "하루종일",
                            "하루종일", "4PM ~ 9AM", "4PM ~ 9AM", "4PM ~ 9AM", "4PM ~ 9AM",
                            "하루종일", "하루종일", "4PM ~ 9AM", "9AM ~ 4PM", "9AM ~ 4PM",
                            "4PM ~ 9AM", "9AM ~ 4PM", "9AM ~ 4PM", "9AM ~ 4PM", "9AM ~ 4PM, 9PM ~ 4AM",
                            "4PM ~ 9AM", "4AM ~ 9PM", "4PM ~ 9AM", "4PM ~ 9AM", "9PM ~ 4AM",
                            "하루종일", "하루종일", "하루종일", "하루종일", "하루종일",
                            "하루종일", "4AM ~ 9PM", "하루종일", "9PM ~ 4AM", "하루종일",
                            "4AM ~ 9PM", "하루종일", "하루종일", "하루종일", "하루종일",
                            "하루종일", "하루종일", "하루종일", "하루종일", "하루종일",
                            "하루종일", "하루종일", "하루종일", "하루종일", "4AM ~ 9PM",
                            "4AM ~ 9PM", "4PM ~ 9AM", "4PM ~ 9AM", "4PM ~ 9AM", "하루종일",
                            "하루종일", "4PM ~ 9AM", "하루종일", "9PM ~ 4AM", "하루종일"};
        size = new String[] {"1", "1", "2", "3", "4", "4", "1", "1", "2", "1",
                            "2", "4", "4", "1", "2", "2", "2", "4", "4", "2",
                            "3", "4", "3", "5", "2", "3", "3", "3", "3", "5",
                            "4", "5", "2", "1", "1", "2", "2", "1", "1", "2",
                            "4", "5", "5", "6", "4", "6", "1", "1", "1", "2",
                            "2", "6", "3", "3", "3", "2", "2", "3", "5", "4",
                            "3", "5", "3", "가느다람", "가느다람", "6", "6", "5", "5", "6 (지느러미)",
                            "5", "6 (지느러미)", "6 (지느러미)", "6 (지느러미)", "6 (지느러미)",
                            "4 (지느러미)", "4", "6", "2", "6"};
        rarity = new String[] {"★", "★★★", "★★", "★★", "★★", "★★★★", "★★★★", "★★★★", "★★★★★", "★★★",
                            "★", "★★★★", "★★★", "★", "★", "★★★", "★", "★★", "★★★", "★★★",
                            "★★", "★", "★★", "★★★", "★", "★★", "★★★", "★★★", "★★★★★", "★★★★★",
                            "★", "★★★★", "★★★★", "★★★★", "★★★★", "★★★", "★★★", "★★★", "★★★", "★★★★",
                            "★★★★★", "★★★★", "★★★★", "★★★★★", "★★★★★", "★★★★", "★★★", "★★", "★★★", "★★★",
                            "★★★", "★★★★", "★", "★★★★", "★★★", "★★★", "★", "★★★★", "★", "★★★",
                            "★★", "★★★", "★★", "★★★★★", "★★★", "★★★★", "★★★★", "★★★★", "★★★★★", "★★★★★",
                            "★★★★", "★★★★", "★★★★", "★★★★★", "★★★★", "★★★", "★★★", "★★★★", "★★★★", "★★★★★"};
        buttons = new JButton[80];
        monthButtons = new JButton[13];
        
        /* 월 버튼 배치 */
        for (int i = 0; i < 12; i++)
        {
            monthButtons[i] = new JButton (i + 1 + "월");
            monthButtons[i].setBackground (Color.WHITE);
            int x = i % 2 * 115;
            int y = i / 2 * 80 + 80;
            monthButtons[i].setBounds (x, y, 115, 80);
            add (monthButtons[i]);
        }

        monthButtons[12] = new JButton ("전체");
        monthButtons[12].setBackground (Color.WHITE);
        monthButtons[12].setBounds (0, 0, 230, 80);
        add (monthButtons[12]);

        /* 월 버튼 기능 */
        for (int i = 0; i < monthButtons.length; i++)
        {
            int monthIndex = i;
            monthButtons[i].addActionListener (e ->
            {
                for (var button : monthButtons)
                    button.setBackground (Color.WHITE);
                monthButtons[monthIndex].setBackground (new Color (200, 200, 200));  // 누르면 회색으로 바뀜
                filterButtons (monthIndex);  // 월별로 필터링
            });
        }

        /* 물고기 버튼 배치 */
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new JButton (new ImageIcon ("src/images/fish/fish" + i + ".png"));
            buttons[i].setBackground (Color.WHITE);

            int x = i % 10 * 80 + 230;
            int y = i / 10 * 80;  // 10개 배치될 때마다 한 칸씩 내리기
            buttons[i].setBounds (x, y, 80, 80);  // 버튼 크기는 80 * 80으로 지정
            add (buttons[i]);

            int buttonIndex = i;
            buttons[i].addActionListener (e -> notifyButtonPressed ("이름: " + name[buttonIndex] + "\n가격: " + price[buttonIndex]
            + "\n장소: " + place[buttonIndex] + "\n시기: " + month[buttonIndex] + "\n시간: " + time[buttonIndex]
            + "\n사이즈: " + size[buttonIndex] + "\n희귀도: " + rarity[buttonIndex], buttonIndex));  // 누르면 팝업창으로 물고기 정보 출력
        }
    }

    /* 팝업 메시지 창 */
    private void notifyButtonPressed (String message, int buttonIndex)
    {
        JPanel panel = new JPanel (new FlowLayout ());
        JLabel fishIcon = new JLabel (new ImageIcon ("src/images/fish/fish" + buttonIndex + ".png"));
        JTextArea textArea = new JTextArea (message);
        textArea.setEditable (false);  // textArea 수정 불가

        /* textarea와 fishIcon에 검은색 테두리 추가 */
        Border border = BorderFactory.createLineBorder (Color.BLACK);
        textArea.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (10, 10, 10, 10)));
        fishIcon.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (0, 0, 0, 0)));

        panel.add (fishIcon); panel.add (textArea);
        JOptionPane.showMessageDialog (this, panel, "물고기 정보", JOptionPane.PLAIN_MESSAGE);
    }

    /* 월별로 물고기 필터링하는 함수 */
    private void filterButtons (int month)
    {
        for (int i = 0; i < buttons.length; i++)
        {
            if (month == 12 || canCatch[i][month])  // 선택한 월의 버튼만 보이게 함 (month == 12는 전체 선택)
                buttons[i].setVisible (true);
            else
                buttons[i].setVisible (false);
        }
    }
}
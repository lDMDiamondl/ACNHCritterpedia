import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

class Panel2 extends JPanel
{
    private JButton[] buttons, monthButtons;
    private int[] price;
    private String[] name, place, month, time, rarity;
    private boolean[][] canCatch;

    public Panel2 ()
    {
        setBackground (new Color (197, 237, 213));
        setLayout (null);

         /* 곤충의 이름, 판매 가격, 포획 장소, 포획 시기, 포획 가능 여부, 포획 시간, 곤충 희귀도를 기록.*/
        name = new String[] {"배추흰나비", "노랑나비", "호랑나비", "제비나비", "청띠제비나비",
                            "왕얼룩나비", "왕오색나비", "왕나비", "몰포나비", "아그리아스나비",
                            "붉은목도리비단나비", "알렉산드라비단제비나비", "나방", "아틀라스나방", "마다가스카르단제비나방",
                            "방아깨비", "섬풀무치", "메뚜기", "여치", "귀뚜라미",
                            "방울벌레", "사마귀", "연꽃사마귀", "꿀벌", "벌",
                            "유지매미", "참매미", "곰매미", "애매미", "쓰르라미",
                            "매미 허물", "고추잠자리", "왕잠자리", "장수잠자리", "실잠자리",
                            "반디", "땅강아지", "소금쟁이", "물방개", "물장군",
                            "노린재", "인면노린재", "무당벌레", "길앞잡이", "비단벌레",
                            "바이올린벌레", "알락하늘소", "루리하늘소", "유포루스바구미", "쇠똥구리",
                            "보라금풍뎅이", "보석풍뎅이", "풍이", "골리앗왕꽃무지", "톱사슴벌레",
                            "사슴벌레", "왕사슴벌레", "뮤엘러리사슴벌레", "엘라푸스가위사슴벌레", "황금사슴벌레",
                            "기라파톱사슴벌레", "장수풍뎅이", "코카서스장수풍뎅이", "코끼리장수풍뎅이", "헤라클레스장수풍뎅이",
                            "긴수염대벌레", "잎사귀벌레", "도롱이벌레", "개미", "소라게",
                            "갯강구", "파리", "모기", "벼룩", "달팽이",
                            "공벌레", "지네", "거미", "타란툴라", "전갈"};
        price = new int[] {160, 160, 240, 2500, 300, 1000, 3000, 140, 4000, 3000,
                            2500, 4000, 130, 3000, 2500, 200, 600, 400, 160, 130,
                            430, 430, 2400, 200, 2500, 250, 300, 500, 400, 550,
                            10, 180, 230, 4500, 500, 300, 500, 130, 800, 2000,
                            120, 1000, 200, 1500, 2400, 450, 350, 3000, 800, 3000,
                            300, 10000, 200, 8000, 2000, 1000, 10000, 6000, 8000, 12000,
                            12000, 1350, 8000, 8000, 12000, 600, 600, 600, 80, 1000,
                            200, 60, 130, 70, 250, 250, 300, 600, 8000, 8000};
        place = new String[] {"비행 (꽃 주변)", "비행 (꽃 주변)", "비행 (꽃 주변)", "비행 (교배꽃 주변)", "비행 (꽃 주변)",
                            "비행 (꽃 주변)", "비행 (꽃 주변)", "비행 (꽃 주변)", "비행 (꽃 주변)", "비행 (꽃 주변)",
                            "비행 (꽃 주변)", "비행 (꽃 주변)", "불빛 주위 비행", "나무 위", "비행 (꽃 주변)",
                            "땅 위", "땅 위", "땅 위", "땅 위", "땅 위",
                            "땅 위", "꽃 위", "꽃 위", "비행", "나무를 흔들면 나옴",
                            "나무 위", "나무 위", "나무 위", "나무 위", "나무 위",
                            "나무 위", "비행", "비행", "비행", "비행",
                            "비행", "소리가 들리는 땅 속", "연못, 강 위", "연못, 강 위", "연못, 강 위",
                            "꽃 위", "꽃 위", "꽃 위", "땅 위", "그루터기 위",
                            "그루터기 위", "그루터기 위", "그루터기 위", "야자수 위", "눈덩이를 굴리고 있음",
                            "땅 위", "나무 위", "나무 위", "야자수 위", "나무 위",
                            "나무 위", "나무 위", "나무 위", "야자수 위", "야자수 위",
                            "야자수 위", "나무 위", "야자수 위", "야자수 위", "야자수 위",
                            "나무 위", "나뭇잎으로 위장", "나무를 흔들면 나옴", "썩은 음식 위", "해변에서 소라로 위장",
                            "해변가 바위 위", "쓰레기 위", "비행", "주민 머리 위", "비 오는 날 바위 위",
                            "바위를 치면 나옴", "바위를 치면 나옴", "나무를 흔들면 나옴", "땅 위, 쫓아옴", "땅 위, 쫓아옴"};
        month = new String[] {"9 ~ 6", "3 ~ 6, 9 ~ 10", "3 ~ 9", "3 ~ 6", "4 ~ 8",
                            "365일", "5 ~ 8", "9 ~ 11", "6 ~ 9, 12 ~ 3", "4 ~ 9",
                            "4 ~ 9, 12 ~ 2", "5 ~ 9", "365일", "4 ~ 9", "4 ~ 9",
                            "4 ~ 11", "8 ~ 11", "8 ~ 11", "7 ~ 9", "9 ~ 11",
                            "9 ~ 10", "3 ~ 11", "3 ~ 11", "3 ~ 7", "365일",
                            "7 ~ 8", "7 ~ 8", "7 ~ 8", "8 ~ 9", "7 ~ 8",
                            "7 ~ 8", "9 ~ 10", "4 ~ 10", "5 ~ 10", "11 ~ 2",
                            "6", "11 ~ 5", "5 ~ 9", "5 ~ 9", "4 ~ 9",
                            "3 ~ 10", "3 ~ 10", "3 ~ 6, 10", "2 ~ 10", "4 ~ 8",
                            "5 ~ 6, 9 ~ 11", "365일", "5 ~ 9", "7 ~ 8", "12 ~ 2",
                            "7 ~ 9", "7 ~ 8", "6 ~ 8", "6 ~ 9", "7 ~ 8",
                            "7 ~ 8", "7 ~ 8", "6 ~ 9", "7 ~ 8", "7 ~ 8",
                            "7 ~ 8", "7 ~ 8", "7 ~ 8", "7 ~ 8", "7 ~ 8",
                            "7 ~ 11", "7 ~ 9", "365일", "365일", "365일",
                            "365일", "365일", "6 ~ 9", "4 ~ 11", "365일",
                            "9 ~ 6", "9 ~ 6", "365일", "11 ~ 4", "5 ~ 10"};
        canCatch = new boolean[][] {{true, true, true, true, true, true, false, false, true, true, true, true},
                            {false, false, true, true, true, true, false, false, true, true, false, false},
                            {false, false, true, true, true, true, true, true, true, false, false, false},
                            {false, false, true, true, true, true, false, false, false, false, false, false},
                            {false, false, false, true, true, true, true, true, false, false, false, false}, 
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, false, true, true, true, true, false, false, false, false},
                            {false, false, false, false, false, false, false, false, true, true, true, false},
                            {true, true, true, false, false, true, true, true, true, false, false, true},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {true, true, false, true, true, true, true, true, true, false, false, true},
                            {false, false, false, false, true, true, true, true, true, false, false, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, true, true, false},
                            {false, false, false, false, false, false, false, true, true, true, true, false},
                            {false, false, false, false, false, false, false, true, true, true, true, false},
                            {false, false, false, false, false, false, true, true, true, false, false, false},
                            {false, false, false, false, false, false, false, false, true, true, true, false},
                            {false, false, false, false, false, false, false, false, true, true, false, false},
                            {false, false, true, true, true, true, true, true, true, true, true, false},
                            {false, false, true, true, true, true, true, true, true, true, true, false},
                            {false, false, true, true, true, true, true, false, false, false, false, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, false, true, true, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, false, false, true, true, false, false},
                            {false, false, false, true, true, true, true, true, true, true, false, false},
                            {false, false, false, false, true, true, true, true, true, true, false, false},
                            {true, true, false, false, false, false, false, false, false, false, true, true},
                            {false, false, false, false, false, true, false, false, false, false, false, false},
                            {true, true, true, true, true, false, false, false, false, false, true, true},
                            {false, false, false, false, true, true, true, true, true, false, false, false},
                            {false, false, false, false, true, true, true, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, false, false, false},
                            {false, false, true, true, true, true, true, true, true, true, false, false},
                            {false, false, true, true, true, true, true, true, true, true, false, false},
                            {false, false, true, true, true, true, false, false, false, true, false, false},
                            {false, true, true, true, true, true, true, true, true, true, false, false},
                            {false, false, false, true, true, true, true, true, false, false, false, false},
                            {false, false, false, false, true, true, false, false, true, true, true, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, false, true, true, true, true, true, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {true, true, false, false, false, false, false, false, false, false, false, true},
                            {false, false, false, false, false, false, true, true, true, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, true, true, true, false, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, false, false, false, false},
                            {false, false, false, false, false, false, true, true, true, true, true, false},
                            {false, false, false, false, false, false, true, true, true, false, false, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, false, false, false, false, true, true, true, true, false, false, false},
                            {false, false, false, true, true, true, true, true, true, true, true, false},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, true, true, false, false, true, true, true, true},
                            {true, true, true, true, true, true, false, false, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {true, true, true, true, false, false, false, false, false, false, true, true},
                            {false, false, false, false, true, true, true, true, true, true, false, false}};
        time = new String[] {"4AM ~ 7PM", "4AM ~ 7PM", "4AM ~ 7PM", "4AM ~ 7PM", "4AM ~ 7PM",
                            "8AM ~ 7PM", "4AM ~ 7PM", "4AM ~ 5PM", "5PM ~ 8AM", "8AM ~ 5PM",
                            "8AM ~ 5PM", "8AM ~ 4PM", "7PM ~ 4AM", "7PM ~ 4AM", "8AM ~ 4PM",
                            "8AM ~ 7PM", "8AM ~ 7PM", "8AM ~ 7PM", "8AM ~ 5PM", "5PM ~ 8AM",
                            "5PM ~ 8AM", "8AM ~ 5PM", "8AM ~ 5PM", "8AM ~ 5PM", "하루종일",
                            "8AM ~ 5PM", "8AM ~ 5PM", "8AM ~ 5PM", "8AM ~ 5PM", "4AM ~ 8AM, 4PM ~ 7PM",
                            "하루종일", "8AM ~ 7PM", "8AM ~ 5PM", "8AM ~ 5PM", "하루종일",
                            "7PM ~ 4AM", "하루종일", "8AM ~ 7PM", "8AM ~ 7PM", "7PM ~ 8AM",
                            "하루종일", "7PM ~ 8AM", "8AM ~ 5PM", "하루종일", "하루종일",
                            "하루종일", "하루종일", "하루종일", "하루종일", "하루종일",
                            "하루종일", "11PM ~ 8AM", "하루종일", "5PM ~ 8AM", "하루종일",
                            "하루종일", "11PM ~ 8AM", "7PM ~ 8AM", "5PM ~ 8AM", "5PM ~ 8AM",
                            "5PM ~ 8AM", "5PM ~ 8AM", "5PM ~ 8AM", "5PM ~ 8AM", "5PM ~ 8AM",
                            "4AM ~ 8AM, 5PM ~ 7PM", "하루종일", "하루종일", "하루종일", "7PM ~ 8AM",
                            "하루종일", "하루종일", "5PM ~ 4AM", "하루종일", "하루종일",
                            "11PM ~ 4PM", "4PM ~ 11PM", "7PM ~ 8AM", "7PM ~ 4AM", "7PM ~ 4AM"};
        rarity = new String[] {"★", "★", "★★★", "★★★", "★", "★★", "★★★★", "★★", "★★★", "★★★★",
                            "★★★★", "★★★★", "★", "★★★★★", "★★", "★★", "★★★", "★★★", "★★", "★",
                            "★★★", "★★★", "★★★★", "★", "-", "★", "★★", "★★★", "★★★", "★★",
                            "★★", "★", "★★", "★★★★", "★", "★", "★★★", "★★★", "★★★", "★",
                            "★★★", "★★", "★", "★★★", "★★★★", "★★★", "-", "-", "-", "★★★",
                            "-", "★★★★", "★", "★★★★", "★★★", "★", "★★★★", "★★★★", "★★★★", "★★★★★",
                            "★★★★★", "★★★", "★★★★", "★★★★", "★★★★★", "★★★", "★★★★", "★★★", "★", "★★★",
                            "★★★", "★", "★★", "★★★★", "★★★★", "★★★", "★★★★", "★★★", "★★★★★", "★★★★★"};
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
                monthButtons[monthIndex].setBackground (new Color (200, 200, 200));
                filterButtons(monthIndex);
            });
        }

        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new JButton (new ImageIcon ("src/images/insect/insect" + i + ".png"));
            buttons[i].setBackground (Color.WHITE);

            int x = i % 10 * 80 + 230;
            int y = i / 10 * 80;  // 10개 배치될 때마다 한 칸씩 내리기
            buttons[i].setBounds (x, y, 80, 80);  // 버튼 크기는 80 * 80으로 지정
            add (buttons[i]);

            int buttonIndex = i;
            buttons[i].addActionListener (e -> notifyButtonPressed ("이름: " + name[buttonIndex] + "\n가격: " + price[buttonIndex]
            + "\n장소: " + place[buttonIndex] + "\n시기: " + month[buttonIndex] + "\n시간: " + time[buttonIndex]
            + "\n희귀도: " + rarity[buttonIndex], buttonIndex));
        }
    }

    private void notifyButtonPressed (String message, int buttonIndex)
    {
        JPanel panel = new JPanel (new FlowLayout ());
        JLabel insectIcon = new JLabel (new ImageIcon ("src/images/insect/insect" + buttonIndex + ".png"));
        JTextArea textArea = new JTextArea (message);
        textArea.setEditable (false);  // textArea 수정 불가

        /* textarea와 insectIcon에 검은색 테두리 추가 */
        Border border = BorderFactory.createLineBorder (Color.BLACK);
        textArea.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (10, 10, 10, 10)));
        insectIcon.setBorder (BorderFactory.createCompoundBorder (border, BorderFactory.createEmptyBorder (0, 0, 0, 0)));

        panel.add (insectIcon); panel.add (textArea);
        JOptionPane.showMessageDialog (this, panel, "곤충 정보", JOptionPane.PLAIN_MESSAGE);
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
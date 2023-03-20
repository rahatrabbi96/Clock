import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Clock {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 100;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);
                int am_pm = calendar.get(Calendar.AM_PM);
                String am_pm_str = (am_pm == Calendar.AM) ? "AM" : "PM";
                String time = String.format("%02d:%02d:%02d %s", hour == 0 ? 12 : hour, minute, second, am_pm_str);
                timeLabel.setText(time);
            }
        });
        timer.start();

        frame.add(timeLabel);
        frame.setVisible(true);
    }
}

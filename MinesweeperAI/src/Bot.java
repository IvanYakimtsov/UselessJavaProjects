import java.awt.*;
import java.awt.image.*;

/**
 * Created by Ivan on 11.05.2017.
 */
public class Bot {

    private int ScreenWidth;
    private int ScreenHeight;

    private int BoardWidth = 0;
    private int BoardHeight = 1;

    private double BoardPix = 0;
    private int BoardTopW = 0;
    private int BoardTopH = 0;

//
//    public Bot(){
//       calibrate();
//    }

    private BufferedImage screenShotImage() {
        try {
            Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            ScreenWidth = captureSize.width;
            ScreenHeight = captureSize.height;
            Robot robot = new Robot();
            BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
            return bufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Take a screenshot and try to figure out the board dimensions and stuff like that
    public void calibrate() {

        System.out.println("Calibrating Screen...");

        BufferedImage screenShot = screenShotImage();
        screenShot.createGraphics();
        Graphics2D g = (Graphics2D) screenShot.getGraphics();


        int hh = 0; // boardheight of previous column
        int firh = 0; // position of first found
        int firw = 0;
        int lash = 0; // position of last found
        int lasw = 0;
        int tot = 0; // total number of crosses found


        for (int w = 0; w < ScreenWidth; w++) {

            for (int h = 0; h < ScreenHeight; h++) {
                int rgb = screenShot.getRGB(w, h);

                if (isDark(rgb)) {

                    if (w < 10 || h < 10 || w > ScreenWidth - 10 || h > ScreenHeight - 10)
                        continue;

                    // look for the cross shape to indicate position on board
                    // we consider it a cross if:
                    //   - the square is dark
                    //   - four selected pixels to the N,S,E,W are dark
                    //   - four selected pixels to the NE, SE, NW, SW are not dark
                    if (isDark(screenShot.getRGB(w + 7, h)))
                        if (isDark(screenShot.getRGB(w - 7, h)))
                            if (isDark(screenShot.getRGB(w, h + 7)))
                                if (isDark(screenShot.getRGB(w, h - 7)))
                                    if (isDark(screenShot.getRGB(w + 3, h)))
                                        if (isDark(screenShot.getRGB(w - 3, h)))
                                            if (isDark(screenShot.getRGB(w, h + 3)))
                                                if (isDark(screenShot.getRGB(w, h - 3)))
                                                    if (!isDark(screenShot.getRGB(w - 7, h - 7)))
                                                        if (!isDark(screenShot.getRGB(w + 7, h - 7)))
                                                            if (!isDark(screenShot.getRGB(w - 7, h + 7)))
                                                                if (!isDark(screenShot.getRGB(w + 7, h + 7)))
                                                                    if (!isDark(screenShot.getRGB(w - 3, h - 3)))
                                                                        if (!isDark(screenShot.getRGB(w + 3, h - 3)))
                                                                            if (!isDark(screenShot.getRGB(w - 3, h + 3)))
                                                                                if (!isDark(screenShot.getRGB(w + 3, h + 3))) {

                                                                                    g.setColor(Color.YELLOW); // for _calibrate.png
                                                                                    g.fillRect(w - 3, h - 3, 7, 7);
                                                                                    tot++;
                                                                                    BoardHeight++;

                                                                                    // Find the position of the first cross
                                                                                    if (firh == 0) {
                                                                                        firh = h;
                                                                                        firw = w;
                                                                                    }

                                                                                    // Note position of the last cross
                                                                                    lash = h;
                                                                                    lasw = w;
                                                                                }
                }


            }

            if (BoardHeight > 1) {
                hh = BoardHeight;
                BoardHeight = 1;
            }
        }

        // Determine boardwidth from total and boardheight
        BoardHeight = hh;
        if (tot % (BoardHeight - 1) == 0)
            BoardWidth = tot / (BoardHeight - 1) + 1;
        else BoardWidth = 0;

        // Determine BoardPix by taking an average
        BoardPix = 0.5 * ((double) (lasw - firw) / (double) (BoardWidth - 2))
                + 0.5 * ((double) (lash - firh) / (double) (BoardHeight - 2));

        // Determine first cell position (where to click)
        int halfsiz = (int) BoardPix / 2;
        BoardTopW = firw - halfsiz + 3;
        BoardTopH = firh - halfsiz + 3;


        System.out.printf("BoardWidth=%d, BoardHeight=%d, BoardPix=%f\n", BoardWidth, BoardHeight, BoardPix);
        System.out.printf("BoardTopW=%d, BoardTopH=%d\n", BoardTopW, BoardTopH);


    }


    private boolean isDark(int rgb){
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        return red + green + blue < 120;
    }

    private int colorDifference(int r1, int g1, int b1, int r2, int g2, int b2){
        return Math.abs(r1 - r2) + Math.abs(b1 - b2) + Math.abs(g1 - g2);
    }

}

package arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        byte[][][] img= new byte[6][6][4];

        byte count = 0;
        for(int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length ; j++) {
                img[i][j][0] = count;
                count++;
            }
        }

        RotateMatrix rm = new RotateMatrix();
        rm.print(img);

        byte[][][] img2 = rm.rotateImages(img);
        System.out.println("----");

        rm.print(img2);
    }

    public byte[][][] rotateImages(byte[][][] img) {

        byte[] tmp1;
        byte[] tmp2;
        for(int i = 0; i < img.length /2; i ++) {
            int last = img.length -1 -i;
            for(int j =i; j < last; j++) {
                tmp1 = img[j][last];
                img[j][last] = img[i][j];
                
                tmp2 = img[last][img.length-1-j];
                img[last][img.length-1-j] = tmp1;
                
                tmp1=img[img.length-1-j][i];
                img[img.length-1-j][i] = tmp2;

                img[i][j] = tmp1;
            }
        }
        return img;
    }

    public void print(byte[][][] img) {

        for(int i = 0; i < img.length; i++) {
            System.out.print("[");
            for(int j = 0; j< img[i].length; j++) {
                System.out.print(img[i][j][0] + ", ");
            }
            System.out.println("]");
        }
    }

}
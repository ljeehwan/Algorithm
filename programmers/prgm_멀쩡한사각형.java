package programmers;

public class prgm_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 3;
		int h = 11;
		System.out.println(solution(w, h));
	}
	
    public static long solution(int w, int h) {
        long answer = (long)w*h;
        
        long width = (long)w;
        long height = (long)h;
        long temp = 0;
        long minus = 0;
        
        if(width < height) {
        	for(long i = w ; i > 1 ; i--) {
        		if(w%i == 0 && h%i == 0) {
        			width = w / i;
        			height = h / i;
        			temp = i;
        			break;
        		}
        	}
        	
        	if(width == 1) {
        		minus = height * w;
        	}
        	else {
        		minus = (height/width+1) * w;
        	}
        	answer = answer - minus;
        }
        else if(width > height) {
        	for(long i = h ; i > 1 ; i--) {
        		if(w%i == 0 && h%i == 0) {
        			width = w / i;
        			height = h / i;
        			temp = i;
        			break;
        		}
        	}
        	
        	if(height == 1) {
        		minus = width * h;
        	}
        	else {
        		minus = (width/height+1) * h;
        	}
        	answer = answer - minus;
        }
        else {
        	minus = w;
        	answer = answer - minus;
        }
        //
        return answer;
    }
}

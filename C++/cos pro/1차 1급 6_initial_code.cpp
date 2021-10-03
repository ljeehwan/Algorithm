//// You may use include as below.
//#include <iostream>
//#include <string>
//#include <vector>
//using namespace std;
//
//int solution(string pos) {
//    // Write code here.
//    int answer = 0;
//
//	//A 0 B 1 C 2 D 3 E 4 F 5 G 6 H 7 I 8
//	//8 0 7 1 6 2 5 3 4 4 3 5 2 6 1 7
//	
//	int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
//	int dy[] = { 1, 2, 1, 2, -1, -2, -2, -1 };
//
//	int x = pos[0] - 'A';
//	int y = '8' - pos[1];
//
//	int nx = 0;
//	int ny = 0;
//
//	for (int i = 0; i < 8; i++){
//		nx = x + dx[i];
//		ny = y + dy[i];
//		if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8){
//			answer++;
//		}
//	}
//
//
//    return answer;
//}
//
//// The following is main function to output testcase.
//int main() {
//    string pos = "D4";
//    int ret = solution(pos);
//
//    // Press Run button to receive output. 
//    cout << "Solution: return value of the function is " << ret << " ." << endl;
//}
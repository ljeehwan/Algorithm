//// 다음과 같이 include를 사용할 수 있습니다.
//#include <iostream>
//#include <string>
//#include <vector>
//
//using namespace std;
//
//string solution(string phrases, int second) {
//    // 여기에 코드를 작성해주세요.
//    string answer = "";
//
//	int len = phrases.length();
//	string temp = "";
//	if (second <= len){
//		for (int i = 0; i < len - second; i++){
//			temp = temp + "_";
//		}
//		answer = temp + phrases.substr(0, second);
//	}
//	else{
//
//	}
//
//    return answer;
//}
//
//// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
//int main() {
//    string phrases = "happy-birthday";
//    int second = 3;
//    string ret = solution(phrases, second);
//
//    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//    cout << "solution 함수의 반환 값은 " << ret << " 입니다." << endl;
//}
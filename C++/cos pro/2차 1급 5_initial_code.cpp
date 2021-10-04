//// 다음과 같이 include를 사용할 수 있습니다.
//#include <iostream>
//#include <string>
//#include <vector>
//
//using namespace std;
//
//int solution(vector<int> arr) {
//    // 여기에 코드를 작성해주세요.
//    int answer = 0;
//	int max = 0;
//	int len = arr.size();
//	bool flag = false;
//	int cnt = 1;
//	int temp = arr[0];
//	for (int i = 1; i < len; i++){
//		if (flag == false && temp < arr[i]){
//			flag = true;
//			cnt++;
//			temp = arr[i];
//		}
//		else if(flag == true && temp < arr[i]) {
//			cnt++;
//			temp = arr[i];
//		}
//		else {
//			flag = false;
//			if (answer < cnt){
//				answer = cnt;
//			}
//			cnt = 1;
//			temp = arr[i];
//		}
//	}
//
//
//    return answer;
//}
//
//// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
//int main() {
//    vector<int> arr = {3, 3, 3, 4, 5, 1, 2, 5, 3, 4};
//    int ret = solution(arr);
//
//
//    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//    cout << "solution 함수의 반환 값은 " << ret << " 입니다." << endl;
//}
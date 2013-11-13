#include <iostream>
using namespace std;


class Stack { // note: has memory leak
	int theStack[];
	int topOfStack;
	
public:
	Stack(){
		topOfStack = 0;
	}
	
	void push(int value) {
		theStack[++topOfStack] = value;
	}
	
	int pop() {
		return theStack[topOfStack--];
	}
	
	int top() {
		return theStack[topOfStack];
	}	
		
};


int main() {
	Stack myStack;
	myStack.push(10);
	myStack.push(11);
	myStack.push(12);
	myStack.push(13);
	cout << myStack.top() << endl;
	cout << myStack.pop() << endl;
	cout << myStack.pop() << endl;
	myStack.push(100);
	cout << "Just pushed 100" << endl;
	cout << myStack.top() << endl;
	cout << myStack.pop() << endl;
	cout << myStack.pop() << endl;
	cout << myStack.top() << endl;
	
	return 0;
}
int function(int x){
    int f, a;
    a = x -2;
    f = (x + 6) * 5 / (a/2 +1);
    return f;
}

int main(){
    return function(6);
}
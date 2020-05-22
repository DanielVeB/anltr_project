int fun(int posX, int posY){
    int pos = posX * 2 - posY * 5;
    return pos + 1;
}
int main(){
    return fun(8,2);
}
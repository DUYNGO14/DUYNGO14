#include<bits/stdc++.h>
using namespace std;
class Date{
	private:
		int D,M,Y;
	public:
		void Nhap(){
			cout<<"Nhap ngay/thang/nam: "; cin>>D>>M>>Y;
		}
		void Xuat(){
			cout<<setw(5)<<right<<D<<setw(1)<<"/"<<setw(2)<<M<<setw(1)<<"/"<<setw(2)<<Y;
		}
		int GetNgay(){
			return this->D;
		}
		int GetThang(){
			return this->M;
		}
		int GetNam(){
			return this->Y;
		}
		friend class Congnhan;
};
class Canbo{
	private:
		string MaCb;
		string Hoten;
		string Sex;
	public:
		void Nhap(){
			cout<<"Nhap ma can bo: ";   fflush(stdin);  getline(cin,MaCb);
			cout<<"Nhap ho ten can bo :"; fflush(stdin); getline(cin,Hoten);
			cout<<"Nhap gioi tinh: "; fflush(stdin); getline(cin,Sex);
		}
		void Xuat(){
			cout<<setw(10)<<MaCb<<setw(20)<<Hoten<<setw(5)<<Sex;
		}
		string GetSex(){
			return this->Sex;
		}
};
class Congnhan:public Canbo{
	private:
		int Bac;
		float SoNL;
		Date NgayKHD;
	public:
		void Nhap(){
			Canbo::Nhap();
			cout<<"Nhap bac (1-3): "; cin>>Bac;
			cout<<"Nhap so ngay lam: "; cin>>SoNL;
			NgayKHD.Nhap();
		}
		float TinhLuong(Congnhan a){
			if(a.Bac==1) return a.SoNL*300000;
			if(a.Bac==2) return a.SoNL*350000;
			if(a.Bac==3) return a.SoNL*400000;
		}
		void Xuat(){
			Canbo::Xuat();
			cout<<setw(5)<<Bac<<setw(10)<<SoNL;
			NgayKHD.Xuat();
		}
		friend bool operator > (Congnhan a,Congnhan b){
			if(a.NgayKHD.GetNam()!=b.NgayKHD.GetNam()) return a.NgayKHD.GetNam()>b.NgayKHD.GetNam();
			else 
				if(a.NgayKHD.GetThang()!=b.NgayKHD.GetThang()) return a.NgayKHD.GetThang()>b.NgayKHD.GetThang();
				else return a.NgayKHD.GetNgay()>b.NgayKHD.GetNgay();
		}
};
void Gach(int x){
	cout<<setfill('-');
	cout<<setw(x)<<"-"<<endl;
	cout<<setfill(' ');
}
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	Congnhan *a;
	int n; cout<<"Nhap so luong cong nhan: "; cin>>n;
	a= new Congnhan[n];
	for(int i=0;i<n;i++){
		cout<<"Cong nhan thu "<<i+1<<endl;
		a[i].Nhap();
	}
	for(int i=0;i<n;i++)
	{
		for(int j=i;j<n;j++){
			if(a[i]>a[j]) swap(a[i],a[j]);
		}
	}
	cout<<"\n SAP XEP THEO NGAY KI HOP DONG"<<endl;
	Gach(71);
	for(int i=0;i<n;i++)
	{
		a[i].Xuat();
		cout<<setw(10)<<(size_t)a[i].TinhLuong(a[i])<<endl;
	}
	Gach(71);
	float max=0;
	cout<<"\t\t CONG NHAN NAM"<<endl;
	Gach(71);
	for(int i=0;i<n;i++){
		if(max<a[i].TinhLuong(a[i])){
			max=a[i].TinhLuong(a[i]);
		}
		if(a[i].GetSex()=="nam"){
			a[i].Xuat();
			cout<<setw(10)<<(size_t)a[i].TinhLuong(a[i])<<endl;
		}
	}
	Gach(71);
	cout<<"\t\t CONG NHAN CO LUONG CAO NHAT"<<endl;
	Gach(71);
	for(int i=0;i<n;i++){
		if(a[i].TinhLuong(a[i])==max) {
			a[i].Xuat();
			cout<<setw(10)<<(size_t)a[i].TinhLuong(a[i])<<endl;
		}
	}
	Gach(71);
	return 0;
}


Matrix22 A = {
	1,1,
	1,0
};
Matrix22 I= {
	1,0,
	0,1
};
Matrix22 multi(Matrix22 a,Matrix22 b, jlong mod) {
	Matrix22 c;
	for(int i=0; i<2; i++) {
		for(int j=0; j<2; j++) {
			c.a[i][j]=0;
			for(int k=0; k<2; k++)
				c.a[i][j]+=a.a[i][k]*b.a[k][j]%mod;

			c.a[i][j]%=mod;
		}
	}
	return c;
}
Matrix22 power(Matrix22 A,int k, jlong mod) {
	Matrix22 ans=I,p=A;
	while(k) {
		if(k&1) {
			ans=mul(ans,p, mod);
			k--;
		}
		k>>=1;
		p=mul(p,p, mod);
	}
	return ans;
}

void dij() {
	auto u = 0;
	auto dis = new int[300];
	auto v = new bool[300]();
	int min;
	memset(v, false, sizeof(v));
	for (auto i = 0; i < n; ++i) {
		dis[i] = map[source][i];
	}
	v[source] = true;
	for (auto i = 0; i < n; ++i) {
		min = inf;
		for (auto j = 0; j < n; ++j) {
			if (!v[j] and dis[j] < min) {
				min = dis[j];
				u = j;
			}
		}
		v[u] = true;
		for (auto j = 0; j < n; ++j) {
			if (!v[j] and dis[j] > dis[u] + map[u][j]) {
				dis[j] = dis[u] + map[u][j];
			}
		}
	}
	delete v;
}

auto main() -> int {
	return 0;
}


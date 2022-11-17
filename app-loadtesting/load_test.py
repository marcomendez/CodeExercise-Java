from locust import HttpUser, task, TaskSet

credentials = [
    ("Julian",
     "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBlYmMyZmI5N2QyNWE1MmQ5MjJhOGRkNTRiZmQ4MzhhOTk4MjE2MmIiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiT21hciBSb2RyaWd1ZXoiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDYuZ29vZ2xldXNlcmNvbnRlbnQuY29tLy1JSFpuRG9RNDhzMC9BQUFBQUFBQUFBSS9BQUFBQUFBQUFBQS9BTVp1dWNsSkNrNXlFRkY4d0NnS3NnSEk0NXZzZzlVZUNnL3M5Ni1jL3Bob3RvLmpwZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9ndWFyZC1kb2ctMjU3MjIwIiwiYXVkIjoiZ3VhcmQtZG9nLTI1NzIyMCIsImF1dGhfdGltZSI6MTYxNDAyMzU0MiwidXNlcl9pZCI6Imt5a0Z3eFhpWmVicUZOVzFUWkhOcTZOelNaNDIiLCJzdWIiOiJreWtGd3hYaVplYnFGTlcxVFpITnE2TnpTWjQyIiwiaWF0IjoxNjE0MDIzNTQyLCJleHAiOjE2MTQwMjcxNDIsImVtYWlsIjoib21hci5vcnNAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsib21hci5vcnNAZ21haWwuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoicGFzc3dvcmQifX0.KOXF2ECyrjXAeWV46S_Ylf4CxAP06BEgtj8yc_J7Hwm5FFm3IWnA_T-Txl1c-5YVcjNdMD52ybmuSMVXs10xxpgMaqGkCA_K2ZcdulzhSk9Fdvic9VX_m36wCLOzWp9zYcsqqTuaeyMmv01dD87BPQjUIZRlgmeUVApAJHvAU8RPDc2Q-RbQhKD-85mVI6BgHpLffz2-Kuo-M7naWdr0DO9YVgroagL7_6kQXC7LJKMyMKSEDys-U9qIYro9qEulYl9Tp5uCt2HMcXbwFZget7N4CGCXo577DJQXtgApp3OJ45NZphBENyFb87VYYn2-ASoFDVN2toy7CI0YgvLAvQ",
     "191.92.74.181"),
    ("Marco",
     "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBlYmMyZmI5N2QyNWE1MmQ5MjJhOGRkNTRiZmQ4MzhhOTk4MjE2MmIiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiT21hciBSb2RyaWd1ZXoiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDYuZ29vZ2xldXNlcmNvbnRlbnQuY29tLy1JSFpuRG9RNDhzMC9BQUFBQUFBQUFBSS9BQUFBQUFBQUFBQS9BTVp1dWNsSkNrNXlFRkY4d0NnS3NnSEk0NXZzZzlVZUNnL3M5Ni1jL3Bob3RvLmpwZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9ndWFyZC1kb2ctMjU3MjIwIiwiYXVkIjoiZ3VhcmQtZG9nLTI1NzIyMCIsImF1dGhfdGltZSI6MTYxNDAyMzU0MiwidXNlcl9pZCI6Imt5a0Z3eFhpWmVicUZOVzFUWkhOcTZOelNaNDIiLCJzdWIiOiJreWtGd3hYaVplYnFGTlcxVFpITnE2TnpTWjQyIiwiaWF0IjoxNjE0MDIzNTQyLCJleHAiOjE2MTQwMjcxNDIsImVtYWlsIjoib21hci5vcnNAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsib21hci5vcnNAZ21haWwuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoicGFzc3dvcmQifX0.KOXF2ECyrjXAeWV46S_Ylf4CxAP06BEgtj8yc_J7Hwm5FFm3IWnA_T-Txl1c-5YVcjNdMD52ybmuSMVXs10xxpgMaqGkCA_K2ZcdulzhSk9Fdvic9VX_m36wCLOzWp9zYcsqqTuaeyMmv01dD87BPQjUIZRlgmeUVApAJHvAU8RPDc2Q-RbQhKD-85mVI6BgHpLffz2-Kuo-M7naWdr0DO9YVgroagL7_6kQXC7LJKMyMKSEDys-U9qIYro9qEulYl9Tp5uCt2HMcXbwFZget7N4CGCXo577DJQXtgApp3OJ45NZphBENyFb87VYYn2-ASoFDVN2toy7CI0YgvLAvQ",
     "191.92.74.181"),
    ("Omar",
     "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBlYmMyZmI5N2QyNWE1MmQ5MjJhOGRkNTRiZmQ4MzhhOTk4MjE2MmIiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiT21hciBSb2RyaWd1ZXoiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDYuZ29vZ2xldXNlcmNvbnRlbnQuY29tLy1JSFpuRG9RNDhzMC9BQUFBQUFBQUFBSS9BQUFBQUFBQUFBQS9BTVp1dWNsSkNrNXlFRkY4d0NnS3NnSEk0NXZzZzlVZUNnL3M5Ni1jL3Bob3RvLmpwZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9ndWFyZC1kb2ctMjU3MjIwIiwiYXVkIjoiZ3VhcmQtZG9nLTI1NzIyMCIsImF1dGhfdGltZSI6MTYxNDAyMzU0MiwidXNlcl9pZCI6Imt5a0Z3eFhpWmVicUZOVzFUWkhOcTZOelNaNDIiLCJzdWIiOiJreWtGd3hYaVplYnFGTlcxVFpITnE2TnpTWjQyIiwiaWF0IjoxNjE0MDIzNTQyLCJleHAiOjE2MTQwMjcxNDIsImVtYWlsIjoib21hci5vcnNAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsib21hci5vcnNAZ21haWwuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoicGFzc3dvcmQifX0.KOXF2ECyrjXAeWV46S_Ylf4CxAP06BEgtj8yc_J7Hwm5FFm3IWnA_T-Txl1c-5YVcjNdMD52ybmuSMVXs10xxpgMaqGkCA_K2ZcdulzhSk9Fdvic9VX_m36wCLOzWp9zYcsqqTuaeyMmv01dD87BPQjUIZRlgmeUVApAJHvAU8RPDc2Q-RbQhKD-85mVI6BgHpLffz2-Kuo-M7naWdr0DO9YVgroagL7_6kQXC7LJKMyMKSEDys-U9qIYro9qEulYl9Tp5uCt2HMcXbwFZget7N4CGCXo577DJQXtgApp3OJ45NZphBENyFb87VYYn2-ASoFDVN2toy7CI0YgvLAvQ",
     "191.92.74.181")
]


class UserBehavior(TaskSet):

    def on_start(self):
        self.userName, self.token, self.ip = credentials.pop()

    @task
    def get_find_Devices(self):
        print("Execution with " + self.userName + " Credentials")
        print("Execution with " + self.token + " Credentials")
        print("Execution with " + self.ip + " Credentials")

        response = self.client.get("api/user/devices?ip=" + self.ip,
                                   headers={
                                       "authorization": self.token
                                   },
                                   )
        data = response.json()
        print(data)

    @task
    def get_user_device(self):
        print("Execution with " + self.userName + " Credentials")
        print("Execution with " + self.token + " Credentials")
        print("Execution with " + self.ip + " Credentials")
        response = self.client.post(
            "api/pull-data",
            {"ip": "200.87.208.237"},
            headers={
                "Host": "guard-dog-257220.wm.r.appspot.com",
                "Accept": "*/*",
                "Referer": "https://guard-dog-257220.wm.r.appspot.com/app/devices",
                "authorization": self.token
            },
        )
        data = response.json()
        print(data)


class User(HttpUser):
    tasks = [UserBehavior]
    min_wait = 5000
    max_wait = 10000
    host = "https://guard-dog-257220.wm.r.appspot.com/"

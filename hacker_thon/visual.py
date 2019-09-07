import matplotlib.pyplot as plt
import numpy as np
import scipy as sp
import random
import json

# ==== define the locations ====
loc_x = [43.89, 73.92, 109.63, 101.51, 164.417,
         266.478, 281.29, 300.769, 435.091, 451.932,
         380.017, 397.544, 409.525, 422.308, 445.439]
loc_y = [116.97, 130.362, 158.972, 202.799, 53.461,
         142.53, 149.03, 157.752, 63.61, 67.66,
         199.35, 202.393, 206.857, 214.77, 184.943]

# ==== read in map ====
map_figure = plt.imread('.\\map_figure.jpg')

# # ==== read in jason file ====
# j_file = '.\\jdata.json'
# j_data = '{"sensor_id":"u123456","geo_latitude":120.0122423423,"collecting_time":"2019-09-07 10:33:55","geo_longitude":30.28237409,"gyro_data":[0.139932,0.6921973,9.72075107,0.129932,0.6221273,9.62075107],"sensor_type":1}'
#
# dict = json.loads(j_data)
# acc = np.array(dict["gyro_data"])
# print(acc)

# import urllib, json
# import urllib.request
# url = "http://192.168.43.155:7777/api/urbanhive"
#
# response = urllib.request.urlopen(url)
#
# data_raw = json.loads(response.read())
#
# data = (data[0])['gyro_data']
# print(len(data))

# import scipy.fftpack
#
# # Number of samplepoints
# N = 500
# # sample spacing
# T = 0.01
# x = np.linspace(0.0, N*T, N)
# y = np.sin(50.0 * 2.0*np.pi*x) + 0.5*np.sin(80.0 * 2.0*np.pi*x)
# yf = scipy.fftpack.fft(y)
# xf = np.linspace(0.0, 1.0/(2.0*T), N/2)
#
# fig, ax = plt.subplots()
# ax.plot(xf, 2.0/N * np.abs(yf[:N//2]))
# plt.show()
#
#
# # ==== read in data ====
# size = [1000, 2000, 3000, 4000, 1800]
#
# # ==== ploting
fig, ax = plt.subplots()
fig.set_size_inches(28,16)
plt.axis('off')
fig.tight_layout()
ax.imshow(map_figure, extent=[0, 550, 0, 280])

size = [random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000),
random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000), random.uniform(2000,3000), random.uniform(2000,3000),
random.uniform(500,1000), random.uniform(500,1000), random.uniform(500,1000), random.uniform(800,1200), random.uniform(800,1200)]

afl = [random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1),
random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1),
random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1)]

loc_bx = [223.26, 224.071]
loc_by = [182.103, 69.89]
# ax.plot(x, x, '--', linewidth=5, color='firebrick')
for n in range(1000):
    ax.set_aspect('equal')
    # size = [random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000),
    # random.uniform(800,2000), random.uniform(800,2000), random.uniform(800,2000), random.uniform(2000,3000), random.uniform(2000,3000),
    # random.uniform(500,1000), random.uniform(500,1000), random.uniform(500,1000), random.uniform(800,1200), random.uniform(800,1200)]
    #
    # afl = [random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1),
    # random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1),
    # random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1), random.uniform(0,1)]
    #
    # scts_0 = ax.scatter(loc_x, loc_y, s=size,c = np.random.rand(15), cmap="RGB", alpha=afl)
    pscale = 2.6
    scts_1 = ax.scatter(loc_x[0] + random.uniform(0,20), loc_y[0] + random.uniform(0,20), s=size[n%5] * pscale,c = 'r', cmap="RGB", alpha=0.8)
    scts_2 = ax.scatter(loc_x[1] + random.uniform(0,20), loc_y[1] + random.uniform(0,20), s=size[n%5] * pscale,c = 'r', cmap="RGB", alpha=0.8)
    scts_3 = ax.scatter(loc_x[2] + random.uniform(0,20), loc_y[2] + random.uniform(0,20), s=random.uniform(800,2000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_4 = ax.scatter(loc_x[3] + random.uniform(0,20), loc_y[3] + random.uniform(0,20), s=random.uniform(800,2000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_5 = ax.scatter(loc_x[4] + random.uniform(0,20), loc_y[4] + random.uniform(0,20), s=random.uniform(800,2000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_6 = ax.scatter(loc_x[5] + random.uniform(0,20), loc_y[5] + random.uniform(0,20), s=random.uniform(800,2000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_7 = ax.scatter(loc_x[6] + random.uniform(0,20), loc_y[6] + random.uniform(0,20), s=random.uniform(800,2000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_8 = ax.scatter(loc_x[7] + random.uniform(0,20), loc_y[7] + random.uniform(0,20), s=random.uniform(800,2000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_9 = ax.scatter(loc_x[8] + random.uniform(0,20), loc_y[8] + random.uniform(0,20), s=random.uniform(2000,3800) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_10 = ax.scatter(loc_x[9] + random.uniform(0,20), loc_y[9] + random.uniform(0,20), s=random.uniform(2000,3800) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_11 = ax.scatter(loc_x[10] + random.uniform(0,20), loc_y[10] + random.uniform(0,20), s=random.uniform(500,1000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_12 = ax.scatter(loc_x[11] + random.uniform(0,20), loc_y[11] + random.uniform(0,20), s=random.uniform(500,1000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_13 = ax.scatter(loc_x[12] + random.uniform(0,20), loc_y[12] + random.uniform(0,20), s=random.uniform(500,1000) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_14 = ax.scatter(loc_x[13] + random.uniform(0,20), loc_y[13] + random.uniform(0,20), s=random.uniform(800,1200) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))
    scts_15 = ax.scatter(loc_x[14] + random.uniform(0,20), loc_y[14] + random.uniform(0,20), s=random.uniform(800,1200) * pscale,c = 'r', cmap="RGB", alpha=random.uniform(0,1))

    scts_16 = ax.scatter(loc_bx[0] + random.uniform(-20,60), loc_by[0] + random.uniform(-10,60), s=random.uniform(100,1200) * pscale,c = 'b', linewidths = 3, edgecolors = 'b', cmap="RGB", alpha=0.5)
    scts_17 = ax.scatter(loc_bx[1] + random.uniform(-30,60), loc_by[1] + random.uniform(-20,60), s=random.uniform(100,1200) * pscale,c = 'b', linewidths = 3, edgecolors = 'b', cmap="RGB", alpha=0.5)

    plt.pause(0.05)
    plt.draw()
    # plt.show()
    # scts_0.remove()
    scts_1.remove()
    scts_2.remove()
    scts_3.remove()
    scts_4.remove()
    scts_5.remove()
    scts_6.remove()
    scts_7.remove()
    scts_8.remove()
    scts_9.remove()
    scts_10.remove()
    scts_11.remove()
    scts_12.remove()
    scts_13.remove()
    scts_14.remove()
    scts_15.remove()
    scts_16.remove()
    scts_17.remove()





#

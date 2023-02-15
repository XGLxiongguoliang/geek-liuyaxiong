1.阿里云申请四台4G8G的centos7服务器

2.服务器安装组件
hero01:备用，后续安装nginx，作为CICD服务器
hero02:安装docker,然后在docker中安装mysql5.7
hero03:业务服务器，部署jar包
hero04:安装docker,通过docker安装Grafana,influxDB;压缩包解压安装Prometheus

3.各组件之间的关联
*hero01,hero02,hero03通过安装node_exporter，然后由hero04的Prometheus代理。这样hero01,hero02,hero03服务器信息就可以传递给hero04的Prometheus
*jmeter压力机(测试通过本地压测)，压测时Jmeter配置后置处理器，将压测数据推送到hero04的influxDB时序数据库
*最终由hero04的Grafana，获取influxDB和Prometheus的数据，根据自己喜好可设定不同的展示模板，从而完成可视化的完美呈现。

备注:安装的详细过程参考老师的课堂笔记！！！
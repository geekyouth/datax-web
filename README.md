![](.file/.pic/1.png)

# DataX-Web 简介

阿里巴巴在开源 DataX 的时候并未提供任何可视化界面，导致我们在使用的过程中，需要将 JSON 配置文件放到 DataX 的 job 路径下。

随着业务量的增加，企业项目复杂度的层层递进，配置文件的管理和迁移非常不方便，并且每次执行都需要手输命令。

目前 DataX 只支持单机版，多节点之间的协作不能友好的控制，我们希望能有一款界面友好的可视化 UI，搭配 DataX，实现定时任务、分布式数据同步等功能，这些需求就是该项目 `DataX-web` 要解决的问题。

# 开发环境

- JDK 版本建议 1.8.201 以上  
- Python2.7 (如果要支持 Python3 需要修改替换 datax/bin 下面的三个 python 文件，替换文件在 doc/datax-web/datax-python3)  
- 开发和部署的操作系统: MacOS, Windows, Linux  
- 管理本项目元数据的数据库: Mysql5.7  

# 功能

- 1、通过 Web 构建 DataX Json；  
- 2、DataX Json 保存在数据库中，方便任务的迁移，管理；  
- 3、Web 实时查看抽取日志，类似 Jenkins 的日志控制台输出功能；  
- 4、DataX 运行记录展示，可在页面操作停止 DataX 作业；  
- 5、支持 DataX 定时任务，支持动态修改任务状态，启动、停止任务，以及终止运行中任务，即时生效；
- 6、调度采用中心式设计，支持集群部署；  
- 7、任务分布式执行，任务"执行器"支持集群部署；  
- 8、执行器会周期性自动注册任务, 调度中心将会自动发现注册的任务并触发执行；  
- 9、路由策略：执行器集群部署时提供丰富的路由策略，包括：第一个、最后一个、轮询、随机、一致性HASH、最不经常使用、最近最久未使用、故障转移、忙碌转移等；  
- 10、阻塞处理策略：调度过于密集执行器来不及处理时的处理策略，策略包括：单机串行（默认）、丢弃后续调度、覆盖之前调度；  
- 11、任务超时控制：支持自定义任务超时时间，任务运行超时将会主动中断任务；  
- 12、任务失败重试：支持自定义任务失败重试次数，当任务失败时将会按照预设的失败重试次数主动进行重试；  
- 13、任务失败告警；默认提供邮件方式失败告警，同时预留扩展接口，可方便的扩展短信、钉钉等告警方式；
- 14、用户管理：支持在线管理系统用户，存在管理员、普通用户两种角色；
- 15、任务依赖：支持配置子任务依赖，当父任务执行结束且执行成功后将会主动触发一次子任务的执行, 多个子任务用逗号分隔；
- 16、运行报表：支持实时查看运行数据，以及调度报表，如调度日期分布图，调度成功分布图等；
- 17、指定增量字段，配置定时任务自动获取每次的数据区间，任务失败重试，保证数据安全；
- 18、页面可配置 DataX 启动 JVM 参数；
- 19、数据源配置成功后添加手动测试功能；
- 20、可以对常用任务进行配置模板，在构建完 JSON 之后可选择关联模板创建任务；
- 21、jdbc 添加 hive 数据源支持，可在构建 JSON 页面选择数据源生成 column 信息并简化配置；
- 22、优先通过环境变量获取 DataX 文件目录，集群部署时不用指定 JSON 及日志目录；
- 23、通过动态参数配置指定 hive 分区，也可以配合增量实现增量数据动态插入分区；
- 24、任务类型由原来的 DataX 任务扩展到 Shell 任务、Python 任务、PowerShell 任务；
- 25、添加 HBase 数据源支持，JSON 构建可通过 HBase 数据源获取 hbaseConfig，column；
- 26、添加 MongoDB 数据源支持，用户仅需要选择 collectionName 即可完成 JSON 构建；
- 27、添加执行器 CPU、内存、负载的监控页面；
- 28、添加 24 类插件 DataX JSON 配置样例；
- 29、公共字段（创建时间，创建人，修改时间，修改者）插入或更新时自动填充；
- 30、对 swagger 接口进行 token 验证；
- 31、任务增加超时时间，对超时任务 kill datax 进程，可配合重试策略避免网络问题导致的 datax 卡死。


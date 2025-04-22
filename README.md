# path-and-query-param

## Problem

* Quarkus behaves differently when having a parent POM
* Original problem: See `main` branch (`README.md`)
* The problem is not reproducible when having the parent POM

## Steps to reproduce the problem

* Build the projects via the parent / top level POM (`mvn clean install`)
    * All tests are working
* Delete the top level POM or comment out the modules
* Build project `path-and-query-param-usage` (`mvn clean install`)
  * The tests will fail

### The error

```
org.jboss.resteasy.reactive.ClientWebApplicationException: Received: 'Not Found, status code 404' when invoking REST Client method: 'org.acme.rest.ParametersClientApi#stringTypeQuery'

	at org.jboss.resteasy.reactive.client.impl.RestClientRequestContext.unwrapException(RestClientRequestContext.java:205)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.handleException(AbstractResteasyReactiveContext.java:329)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:175)
	at io.smallrye.context.impl.wrappers.SlowContextualRunnable.run(SlowContextualRunnable.java:19)
	at org.jboss.resteasy.reactive.client.handlers.ClientSwitchToRequestContextRestHandler$1$1.handle(ClientSwitchToRequestContextRestHandler.java:38)
	at org.jboss.resteasy.reactive.client.handlers.ClientSwitchToRequestContextRestHandler$1$1.handle(ClientSwitchToRequestContextRestHandler.java:35)
	at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:270)
	at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:252)
	at io.vertx.core.impl.ContextInternal.lambda$runOnContext$0(ContextInternal.java:50)
	at io.netty.util.concurrent.AbstractEventExecutor.runTask$$$capture(AbstractEventExecutor.java:173)
	at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java)
	at --- Async.Stack.Trace --- (captured by IntelliJ IDEA debugger)
	at io.netty.util.concurrent.SingleThreadEventExecutor.addTask(SingleThreadEventExecutor.java)
	at io.netty.util.concurrent.SingleThreadEventExecutor.execute(SingleThreadEventExecutor.java:836)
	at io.netty.util.concurrent.SingleThreadEventExecutor.execute0(SingleThreadEventExecutor.java:827)
	at io.netty.util.concurrent.SingleThreadEventExecutor.execute(SingleThreadEventExecutor.java:817)
	at io.vertx.core.impl.EventLoopExecutor.execute(EventLoopExecutor.java:35)
	at io.vertx.core.impl.ContextInternal.runOnContext(ContextInternal.java:50)
	at org.jboss.resteasy.reactive.client.handlers.ClientSwitchToRequestContextRestHandler$1.execute(ClientSwitchToRequestContextRestHandler.java:35)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.resume(AbstractResteasyReactiveContext.java:91)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.resume(AbstractResteasyReactiveContext.java:57)
	at org.jboss.resteasy.reactive.client.handlers.ClientSendRequestHandler$3$3.handle(ClientSendRequestHandler.java:361)
	at org.jboss.resteasy.reactive.client.handlers.ClientSendRequestHandler$3$3.handle(ClientSendRequestHandler.java:346)
	at io.vertx.core.impl.future.FutureImpl$4.onSuccess(FutureImpl.java:176)
	at io.vertx.core.impl.future.FutureBase.lambda$emitSuccess$0(FutureBase.java:60)
	at io.vertx.core.impl.ContextImpl.execute(ContextImpl.java:312)
	at io.vertx.core.impl.DuplicatedContext.execute(DuplicatedContext.java:168)
	at io.vertx.core.impl.future.FutureBase.emitSuccess(FutureBase.java:57)
	at io.vertx.core.impl.future.FutureImpl.tryComplete(FutureImpl.java:259)
	at io.vertx.core.http.impl.HttpEventHandler.handleEnd(HttpEventHandler.java:79)
	at io.vertx.core.http.impl.HttpClientResponseImpl.handleEnd(HttpClientResponseImpl.java:250)
	at io.vertx.core.http.impl.Http1xClientConnection$StreamImpl.lambda$new$0(Http1xClientConnection.java:421)
	at io.vertx.core.streams.impl.InboundBuffer.handleEvent(InboundBuffer.java:279)
	at io.vertx.core.streams.impl.InboundBuffer.write(InboundBuffer.java:157)
	at io.vertx.core.http.impl.Http1xClientConnection$StreamImpl.handleEnd(Http1xClientConnection.java:731)
	at io.vertx.core.impl.ContextImpl.execute(ContextImpl.java:327)
	at io.vertx.core.impl.DuplicatedContext.execute(DuplicatedContext.java:158)
	at io.vertx.core.http.impl.Http1xClientConnection.handleResponseEnd(Http1xClientConnection.java:962)
	at io.vertx.core.http.impl.Http1xClientConnection.handleHttpMessage(Http1xClientConnection.java:832)
	at io.vertx.core.http.impl.Http1xClientConnection.handleMessage(Http1xClientConnection.java:796)
	at io.vertx.core.net.impl.ConnectionBase.read(ConnectionBase.java:159)
	at io.vertx.core.net.impl.VertxHandler.channelRead(VertxHandler.java:153)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
	at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelRead(CombinedChannelDuplexHandler.java:436)
	at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:346)
	at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:318)
	at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:251)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:442)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:412)
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1357)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:440)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:420)
	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:868)
	at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:166)
	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:796)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:732)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:658)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:562)
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:998)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:1583)
	Suppressed: java.lang.IllegalAccessError: class org.base.types.StringType$quarkusrestparamConverter$ tried to access protected method 'void org.base.types.StringType.<init>(java.lang.String)' (org.base.types.StringType$quarkusrestparamConverter$ is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @44114b9f; org.base.types.StringType is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @3d97a632)
		at org.base.types.StringType$quarkusrestparamConverter$.convert(Unknown Source)
		at org.jboss.resteasy.reactive.server.handlers.ParameterHandler.handleResult(ParameterHandler.java:108)
		at org.jboss.resteasy.reactive.server.handlers.ParameterHandler.handle(ParameterHandler.java:59)
		at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:137)
		at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:147)
		at io.quarkus.vertx.core.runtime.VertxCoreRecorder$15.runWith(VertxCoreRecorder.java:638)
		at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2675)
		at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2654)
		at org.jboss.threads.EnhancedQueueExecutor.runThreadBody(EnhancedQueueExecutor.java:1627)
		at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1594)
		at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:11)
		at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:11)
		... 2 more
	Suppressed: jakarta.ws.rs.NotFoundException: HTTP 404 Not Found
		at org.jboss.resteasy.reactive.server.handlers.ParameterHandler.handleResult(ParameterHandler.java:113)
		at org.jboss.resteasy.reactive.server.handlers.ParameterHandler.handle(ParameterHandler.java:59)
		at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:137)
		at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:147)
		at io.quarkus.vertx.core.runtime.VertxCoreRecorder$15.runWith(VertxCoreRecorder.java:638)
		at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2675)
		at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2654)
		at org.jboss.threads.EnhancedQueueExecutor.runThreadBody(EnhancedQueueExecutor.java:1627)
		at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1594)
		at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:11)
		at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:11)
		... 2 more
	Caused by: [CIRCULAR REFERENCE: java.lang.IllegalAccessError: class org.base.types.StringType$quarkusrestparamConverter$ tried to access protected method 'void org.base.types.StringType.<init>(java.lang.String)' (org.base.types.StringType$quarkusrestparamConverter$ is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @44114b9f; org.base.types.StringType is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @3d97a632)]
Caused by: jakarta.ws.rs.WebApplicationException: Not Found, status code 404
	at io.quarkus.rest.client.reactive.runtime.DefaultMicroprofileRestClientExceptionMapper.toThrowable(DefaultMicroprofileRestClientExceptionMapper.java:19)
	at io.quarkus.rest.client.reactive.runtime.MicroProfileRestClientResponseFilter.filter(MicroProfileRestClientResponseFilter.java:54)
	at org.jboss.resteasy.reactive.client.handlers.ClientResponseFilterRestHandler.handle(ClientResponseFilterRestHandler.java:21)
	at org.jboss.resteasy.reactive.client.handlers.ClientResponseFilterRestHandler.handle(ClientResponseFilterRestHandler.java:10)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.invokeHandler(AbstractResteasyReactiveContext.java:231)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:147)
	... 62 more

```
package com.kai.rajavatest.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kai.rajavatest.entity.NounDescriptor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Cancellable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *
 * @ProjectName:    RajavaTest
 * @Description:     java类作用描述
 * @Author:         pressureKai
 * @UpdateDate:     2021/2/26 11:35
 */
class RxjavaBaseClassDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sample()
    }


    private fun sample(){
        val observableDescriptor = NounDescriptor()
        observableDescriptor.name = "Observable"
        observableDescriptor.descriptor = "可供观察的数据流对象"


        val observableCreateDescriptor = NounDescriptor()
        observableCreateDescriptor.name = "Observable.create<T>(ObservableOnSubscriber<T>(){})"
        observableCreateDescriptor.descriptor = "创建一个生产数据的对象"


        val observableOnSubscriberDescriptor = NounDescriptor()
        observableOnSubscriberDescriptor.name = "ObservableOnSubscriber<T>(){\n fun subscriber(ObservableEmitter<T>()){\n}}"
        observableOnSubscriberDescriptor.descriptor = "数据的生成接口仅有一个抽象方法subscriber() "



        val observableEmitterDescriptor = NounDescriptor()
        observableEmitterDescriptor.name = "ObservableEmitter<T>"
        observableEmitterDescriptor.descriptor = "数据发射者\nonNext(T)\nonError()\nonComplete()"


        val observeOnDescriptor = NounDescriptor()
        observeOnDescriptor.name = "observeOn"
        observeOnDescriptor.descriptor = "定义数据接收线程"


        val subscribeOnDescriptor = NounDescriptor()
        subscribeOnDescriptor.name = "subscribeOn"
        subscribeOnDescriptor.descriptor = "定义数据的生产线程"


        val doOnSubscribeDescriptor = NounDescriptor()
        doOnSubscribeDescriptor.name = "doOnSubscribe"
        doOnSubscribeDescriptor.descriptor = "数据刚被订阅时的回调"


        val doOnCompleteDescriptor = NounDescriptor()
        doOnCompleteDescriptor.name = "doOnComplete"
        doOnCompleteDescriptor.descriptor = "数据回调结束时的回调"


        val subscribeDescriptor = NounDescriptor()
        subscribeDescriptor.name = "subscribe"
        subscribeDescriptor.descriptor = "接收数据的回调"

        // Observable  可供观察的数据
        // create(ObservableOnSubscribe<T>()) 创建一个被订阅的数据对象
        // ObservableOnSubscribe<T>() T : 表示正在被订阅的数据对象
        // 表示可供观察的对象正在被订阅 (重写此ObservableOnSubscribe对象中的{subscribe(ObservableEmitter<T>)}方法)
        // ObservableEmitter<T> : T类型数据的发射者
        // 主要有三个方法 onNext(T),onError(Exception),onComplete()



        // subscribe(Observer())  表示一种订阅行为(方法)
        // Observer<T>  观察者接收数据的一个接口(按上游的发送顺序接收数据)
        // 该继承该接口需实现四个方法
        // 1.onSubscribe 开始订阅
        // 2.onNext(T) 数据接收
        // 3.onComplete() 数据接收完毕
        // 4.onError(Exception) 数据订阅错误


        // 链式使用方法
        // Observable.create(ObservableOnSubscribe<T>()).subscribe(Observer<T>())



        // observeOn(AndroidSchedulers.mainThread()) 表示在android 主线程上观察数据(定义数据的接收线程)
        // subscribeOn(Schedulers.newThread()) 表示在 RxNewThreadSchedulers 上订阅数据(定义数据的生产线程)

        Observable.create<String> {
            it.onNext("1")
            Log.e("Rxjava",Thread.currentThread().name + ": send data 1")
            it.onNext("2")
            Log.e("Rxjava",Thread.currentThread().name + ": send data 2")
            it.onComplete()
            Log.e("Rxjava",Thread.currentThread().name + ": send complete")
        }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe {
                    Log.e("Rxjava",Thread.currentThread().name + ": subscribe")
                }
                .doOnComplete {
                    Log.e("Rxjava",Thread.currentThread().name + ": complete")
                }
                .subscribe {
                    Log.e("Rxjava",Thread.currentThread().name + ": get data $it")
                }
    }
}
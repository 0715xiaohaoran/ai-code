package com.xhr.aicode.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xhr.aicode.model.dto.app.AppQueryRequest;
import com.xhr.aicode.model.entity.App;
import com.xhr.aicode.model.entity.User;
import com.xhr.aicode.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author xhr
 */
public interface AppService extends IService<App> {

    /**
     * 根据应用ID和用户提示词消息生成代码的响应式流方法
     *
     * @param appId     应用程序的唯一标识符
     * @param message   用户输入的提示词
     * @param loginUser 当前登录用户信息
     * @return 返回一个包含生成代码的Flux流，每个元素代表代码的一部分
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 部署应用程序的方法
     *
     * @param appId     应用程序的唯一标识符ID
     * @param loginUser 当前登录的用户信息
     * @return 返回一个字符串，可能表示部署结果或状态信息
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 根据App实体对象获取对应的AppVO对象
     * AppVO通常用于数据传输或展示，可能包含App实体中的部分或全部字段
     *
     * @param app App实体对象，包含完整的应用信息
     * @return AppVO 视图对象，用于前端展示或数据传输
     */
    AppVO getAppVO(App app);

    /**
     * 获取应用视图对象列表
     *
     * @param appList 应用实体对象列表
     * @return 应用视图对象列表
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 根据应用查询请求参数构建查询条件包装器
     *
     * @param appQueryRequest 应用查询请求对象，包含查询条件参数
     * @return QueryWrapper 返回包含查询条件的MyBatis-Plus查询包装器对象，
     * 用于构建数据库查询条件
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);
}

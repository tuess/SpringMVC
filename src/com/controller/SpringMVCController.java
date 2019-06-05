package com.controller;

import com.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//将对象放入session域中,还可以用types输入同一类的对象，如需放入多个类型，需要用大括号括起来再在内部追加
@SessionAttributes("student3")
//@SessionAttributes(types = Student.class)
@Controller
public class SpringMVCController {

//    通过RequestMapping注解拦截welcome请求
//    method指定拦截的请求方式
//    params指定请求必须携带的参数或参数必须为指定值（也可以写不等于）
    @RequestMapping(value="Welcome",method = RequestMethod.GET,params = {"!name"})
    public String Welcome(){
        //在return后加入forward:(请求转发)和redirect:(重定向)即可实现对应的跳转方式,使用这种方式会忽略掉视图解析器加的前缀后缀,需要自己加
        return "redirect:/success.jsp";   //页面跳转时默认用的请求转发
    }

//    可以通过headers指定请求头
//    在value中可以支持ant风格的缩略，?代表单个字符，*代表任意个字符，**代表任意目录
    @RequestMapping(value="Welcome2",headers = {"Accept=text/html, application/xhtml+xml, application/xml; q=0.9, */*; q=0.8"})
    public String Welcome2(){
        return "success";   //页面跳转时默认用的请求转发
    }

//    使用@PathVariable动态获取参数
    @RequestMapping(value="Welcome3/{name}")
    public String Welcome3(@PathVariable("name") String name){
        System.out.println(name);
        return "success";   //页面跳转时默认用的请求转发
    }

    @RequestMapping(value="Add/{id}",method = RequestMethod.POST)
    public String Add(@PathVariable("id") Integer id){
        System.out.println("增加"+id);
        return "success";   //页面跳转时默认用的请求转发
    }

    @RequestMapping(value="Search/{id}",method = RequestMethod.GET)
    public String Search(@PathVariable("id") Integer id){
        System.out.println("查找"+id);
        return "success";   //页面跳转时默认用的请求转发
    }

    @RequestMapping(value="Delete/{id}")
    public String Delete(@PathVariable("id") Integer id){
        System.out.println("删除"+id);
        return "success";   //页面跳转时默认用的请求转发
    }

    @RequestMapping(value="Update/{id}")
    public String Update(@PathVariable("id") Integer id){
        System.out.println("修改"+id);
        return "success";   //页面跳转时默认用的请求转发
    }

    //另一种取值方式
    @RequestMapping(value="Param")
//    @RequestParam('name'),接收前台的传值，等价于request.getParameter("name"),required=false,表示该值不是必须的，defaultValue是默认值，如果不传值的话即用默认值
    public String Param(@RequestParam("name") String name,@RequestParam(value="age",required = false,defaultValue = "23") Integer age){
        System.out.println("输入的值："+name);
        System.out.println("输入的值："+age);
        return "success";   //页面跳转时默认用的请求转发
    }

//    获取请求头信息,@RequestHeader注解后填请求头的key，值赋予了后面的变量
    @RequestMapping(value="Header")
    public String Header(@RequestHeader("Accept") String header){
        System.out.println(header   );
        return "success";   //页面跳转时默认用的请求转发
    }

//    获取cookie信息
    @RequestMapping(value = "Cookie")
    public String Cookie(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

//    用对象来传值
    @RequestMapping(value = "ObjectProperties")
    public String ObjectProperties(Student student){ //student属性必须和表单中的name一致（支持级联属性）
        System.out.println(student.getId()+","+student.getName()+","+student.getAddress().getHomeAddress()+","+student.getAddress().getSchoolAddress());
        return "success";
    }

//    调用原生ServletAPI，将其写在参数中就可以
    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request){
        System.out.println(request);
        return "success";
    }

//    ModelAndView,ModelMap,Model,Map四种传递数据都是将数据放在request域中，如果要放到session域中，需要在类开始加上@SessionAttributes()注解并将对象放入
//    使用ModelAndView传递数据
    @RequestMapping("ModelAndView")
    public ModelAndView ModelAndView(){ //返回值是ModelAndView，既有视图也有数据
        ModelAndView mv = new ModelAndView("success"); //返回的页面放在构造函数中
        Student studnent = new Student();
        studnent.setId(1);
        studnent.setName("zs");
        mv.addObject("student",studnent); //相当于request.setAttribute("student",student);
        return mv;
    }

//    使用ModelMap传递数据
    @RequestMapping("ModelMap")
    public String ModelMap(ModelMap modelMap){ //返回值是ModelAndView，既有视图也有数据
        Student studnent = new Student();
        studnent.setId(2);
        studnent.setName("ls");
        modelMap.put("student1",studnent);
        return "success";
    }

//    使用Map传递数据
    @RequestMapping("Map")
    public String Map(Map<String,Object> map){ //返回值是ModelAndView，既有视图也有数据
        Student studnent = new Student();
        studnent.setId(3);
        studnent.setName("ww");
        map.put("student2",studnent);
        return "success";
    }

//    使用Model传递数据
    @RequestMapping("Model")
    public String Model(Model model){ //返回值是ModelAndView，既有视图也有数据
        Student studnent = new Student();
        studnent.setId(4);
        studnent.setName("zl");
        model.addAttribute("student3",studnent);
        return "success";
    }

//    在任何一次请求前，都会先执行@MODELATTTRIBUTE修饰的方法,慎用
    @ModelAttribute
    public void queryStudentById(Map<String,Object> map){
//        StudentService stuService = new StudentServiceImpl();
//        Student student = stuService.queryStudentById(1);
//        模拟调用三层的查询数据库操作
        Student student = new Student();
        student.setId(10001);
        student.setName("aa");
        map.put("student",student);//约定：map的key就是方法参数类型的首字母小写，这里的student会自动的传到下面的ModelAttribute方法中去,如果不一致需要再用值的地方加上@ModelAttribute()注解
    }

//    使用ModelAttribute更新修改,在修改之前要先查到人再在此基础上修改
    @RequestMapping("ModelAttribute")
    public String ModelAttribute(Student student){ //返回值是ModelAndView，既有视图也有数据
        student.setName("zl");
        System.out.println(student.getId()+","+student.getName());
        return "success";
    }

//    处理国际化，在mvc响应时介入
    @RequestMapping("I18n")
    public String I18n(){ //返回值是ModelAndView，既有视图也有数据
        return "success";
    }

//    测试自定义转换器
    @RequestMapping("Converter")
//    加@RequestParam注解就是告诉程序收到的字符串目标就是学生类,就会自动触发转换器
    public String Converter(@RequestParam("student") Student student){ //返回值是ModelAndView，既有视图也有数据
        System.out.println(student.getId()+","+student.getName());
        return "success";
    }

//    测试日期格式化
    @RequestMapping("DataTimeFormat")
//    数据校验要在被校验的对象前加上@Valid的注解
    public String DataTimeFormat(@Valid Student student, BindingResult result, Map<String,Object> map){ //约定:如果格式化有错,会将错误传递给result,通过map将错误传递给前端
        System.out.println(student.getId()+","+student.getName()+","+student.getBirthday());
//        result的处理相当于异常捕获,前端可以不报错继续进行
        if(result.getErrorCount()>0){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getDefaultMessage());
                map.put("errors",result.getFieldErrors());//将错误放在了request域中
            }
        }
        return "success";
    }

//    测试用ajax请求springMVC
//    添加@ResponseBody注解，就可以在ajax中直接调用json对象，告诉springMVC此时的返回不是一个view页面，而是一个ajax调用的返回值，以json数组的格式返回给前端
    @ResponseBody
    @RequestMapping("testJson")
    public List<Student> testJson(){ //返回值是ModelAndView，既有视图也有数据
       /*正常步骤
        controller->service->dao
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.queryAllStudent();
        return "success";*/

       //模拟调用service的查询操作
        Student stu1 = new Student(1,"zs");
        Student stu2 = new Student(2,"ls");
        Student stu3 = new Student(3,"ww");
        List<Student> students = new ArrayList<>();
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        return students;
    }

//    测试文件上传
    @RequestMapping("FileUpload")
//    通过@RequestParam注解将前端传过来的值保存在后一个变量里面
    public String FileUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("文件描述信息"+desc);
//        jsp中上传的文件：file
        InputStream inputStream = file.getInputStream();
//        获取原始文件名
        String originalFilename = file.getOriginalFilename();
        OutputStream outputStream = new FileOutputStream("E:\\桌面\\"+originalFilename);
        byte[] bytes = new byte[1024];
        int len = -1;
        while((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        outputStream.close();
        inputStream.close();
        System.out.println("上传成功");
        return "success";
    }
}

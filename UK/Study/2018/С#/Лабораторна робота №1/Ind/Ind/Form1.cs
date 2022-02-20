using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ind
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Text = "* * * * * *";
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox1.Text = "* * * * * *";
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            BackColor = Color.Red;
            textBox1.Text = "+ + + + + +";
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            button1.Hide();
            button2.Hide();
            button3.Hide();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            button1.Show();
            button2.Show();
            button3.Show();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            MessageBox.Show(" Індивідуальне завдання №1\n     створив Хаща Василь\n       студент групи КН-21");
        }
    }
}
